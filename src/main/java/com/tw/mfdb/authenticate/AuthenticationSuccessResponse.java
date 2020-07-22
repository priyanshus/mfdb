package com.tw.mfdb.authenticate;

public class AuthenticationSuccessResponse {
    private String token;

    public AuthenticationSuccessResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
