package com.ashish.Email_API.model;

public class DataResponse
{
    private String token;

    public String getToken() {
        return token;
    }
    public DataResponse(String token)
    {
        this.token=token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
