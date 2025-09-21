package com.Bajaj.ApiChallenge.controller;

import com.Bajaj.ApiChallenge.entity.Output;
import com.Bajaj.ApiChallenge.entity.Request;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bfhl")
public class ResponseController {
    @GetMapping
    public String getOperationCode() {
        return "{\"operation_code\": 1}";
    }

    @PostMapping
    public Output handlePost(@RequestBody Request request){
        Output response =  new Output();
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();

        if(request == null || request.getData() == null || request.getData().isEmpty()){
            response.setNumbers(numbers);         // empty
            response.setAlphabets(alphabets);     // empty
            response.setHighestAlphabet(new ArrayList<>()); // empty
            response.setIs_Success(true);            // still success
            return response;
        }


        for (String item : request.getData()){
            if(isNumber(item)){
                numbers.add( item);
            }else {
                alphabets.add(item);
            }
        }

        List<String> highestAlphabet = findHighestAlphabet(alphabets);
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighestAlphabet(highestAlphabet);
        response.setIs_Success(true);
        return response;

    }

    private List<String> findHighestAlphabet(List<String> alphabets) {
        List<String> result = new ArrayList<>();

        if (alphabets.isEmpty()) {
            return result;
        }

        String highest = null;
        for (String alpha : alphabets) {
            if (highest == null || alpha.toUpperCase().charAt(0) > highest.toUpperCase().charAt(0)) {
                highest = alpha;
            }
        }

        if (highest != null) {
            result.add(highest);
        }

        return result;
    }

    public static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    };


}
