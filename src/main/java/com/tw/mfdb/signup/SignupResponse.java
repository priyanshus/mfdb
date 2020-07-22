package com.tw.mfdb.signup;

public class SignupResponse {
    private String otp;

    SignupResponse() {}

    public SignupResponse(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
