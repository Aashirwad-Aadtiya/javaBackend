package com.Bajaj.ApiChallenge.entity;

import java.util.List;

public class Request {
    private List<String> data;

    public Request(){}

    public Request(List<String>data){
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
