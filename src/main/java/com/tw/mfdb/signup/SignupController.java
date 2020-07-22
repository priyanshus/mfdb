package com.tw.mfdb.signup;

import com.tw.mfdb.common.JwtUtil;
import com.tw.mfdb.signup.exceptions.UserAlreadySignedUpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/api/v1")
public class SignupController {
    Logger logger = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    SignupRepository signupRepository;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupUser user) {
        logger.info("Received request for user signup");
        boolean exists = signupRepository.existsById(user.getMobileNumber());
        if (exists) {
            throw new UserAlreadySignedUpException(user.getMobileNumber());
        } else {
            signupRepository.save(user);
        }

        return new SignupResponse(JwtUtil.create("signupOtp"));
    }

}
