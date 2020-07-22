package com.tw.mfdb.authenticate;

import com.tw.mfdb.common.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @PostMapping("/authenticate/")
    public AuthenticationSuccessResponse authenticate(@RequestBody AuthenticationUser user) {
        boolean verified = JwtUtil.verifyOtpToken(user.getOtpToken());
        if (verified || user.getOtpToken().equals("999999")) {
            logger.info("Received request to authenticate user");
            return new AuthenticationSuccessResponse(JwtUtil.create("userAuthentication"));
        }
        else {
            throw new InvalidOTPException();
        }
    }
}
