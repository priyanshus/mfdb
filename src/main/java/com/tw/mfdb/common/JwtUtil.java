package com.tw.mfdb.common;

import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class JwtUtil {
    private static final String KEY = "myawesomekeyforjwtsign139402843093849_1838@344";

    public static String create(String uniqueId) {
        Signer signer = HMACSigner.newSHA256Signer(KEY);

        JWT jwt = new JWT()
                .setUniqueId(uniqueId)
                .setSubject("issued for testing purpose")
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(60));

        return JWT.getEncoder().encode(jwt, signer);
    }

    public static boolean verify(String jwtToken) {
        Verifier verifier = HMACVerifier.newVerifier(KEY);
        try {
            JWT.getDecoder().decode(jwtToken, verifier);
            return true;
        } catch (Exception invalidJwtSign) {
            return false;
        }
    }

    public static boolean verifyOtpToken(String jwtToken) {
        Verifier verifier = HMACVerifier.newVerifier(KEY);
        try {
            JWT decodedToken = JWT.getDecoder().decode(jwtToken, verifier);
            System.out.println(decodedToken.uniqueId);
            return decodedToken.uniqueId.equals("signupOtp");
        } catch (Exception invalidJwtSign) {
            return false;
        }
    }
}
