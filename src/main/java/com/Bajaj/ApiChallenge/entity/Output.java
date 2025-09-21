package com.Bajaj.ApiChallenge.entity;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private  final String USER_ID = "Aashirwad_Aadtiya_14062003";
    private  final String EMAIL = "aadtiyaaashirwad4573@gmail.com";
    private  final String ROLL_NUMBER = "0002AL221003";

    private List<String> numbers = new ArrayList<>();
    private List<String> alphabets = new ArrayList<>();
    private List<String> highestAlphabet = new ArrayList<>();
    private boolean is_Success;

    public String getUSER_ID() {
        return USER_ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getROLL_NUMBER() {
        return ROLL_NUMBER;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public List<String> getHighestAlphabet() {
        return highestAlphabet;
    }

    public boolean isIs_Success() {
        return is_Success;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public void setHighestAlphabet(List<String> highestAlphabet) {
        this.highestAlphabet = highestAlphabet;
    }

    public void setIs_Success(boolean is_Success) {
        this.is_Success = is_Success;
    }
}
