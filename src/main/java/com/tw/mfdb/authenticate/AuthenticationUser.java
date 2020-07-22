package com.tw.mfdb.authenticate;

import javax.validation.Valid;

public class AuthenticationUser {
    @Valid
    private String username;

    @Valid
    private String password;
    private String otpToken;

    public AuthenticationUser(String username, String password, String otpToken) {
        this.username = username;
        this.password = password;
        this.otpToken = otpToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtpToken() {
        return otpToken;
    }

    public void setOtpToken(String otpToken) {
        this.otpToken = otpToken;
    }
}
