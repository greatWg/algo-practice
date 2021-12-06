package com.util;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] code = new byte[32];
        sr.nextBytes(code);
        String verifier = java.util.Base64.getUrlEncoder().withoutPadding().encodeToString(code);
        System.out.println("verifier::" + verifier);//5Kfo60rytbkJuIzF9Nhh7L5pHcee2YkduLetSDbsnZ0


        byte[] bytes = verifier.getBytes("US-ASCII");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes, 0, bytes.length);
        byte[] digest = md.digest();
        String challenge = org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(digest);
        System.out.println("challenge::" + challenge);
        System.out.println("https://preview.enterprise-auth.vip.nordstrom.com/v1/ausg0zujx3faqpGaA0h7/authorize?client_id=0oazg9fb4xYjNM87o0h7&response_type=code&scope=openid&redirect_uri=https://perf-pos-order-search-pos.shared-lb.hydrogen.platform-nonprod.r53.nordstrom.net/login/oauth2/code/okta&state=state-8600b31f-52d1-4dca-987c-386e3d8967e7&code_challenge_method=S256&code_challenge="+challenge);

        /*https://preview.enterprise-auth.vip.nordstrom.com/v1/ausg0zujx3faqpGaA0h7/authorize?client_id=0oazg9fb4xYjNM87o0h7&response_type=code&scope=openid&redirect_uri=https://perf-pos-order-search-pos.shared-lb.hydrogen.platform-nonprod.r53.nordstrom.net/login/oauth2/code/okta&state=state-8600b31f-52d1-4dca-987c-386e3d8967e7&code_challenge_method=S256&code_challenge=yUci2FefnsYS3eKQtxYWiFcGzSMIF005VT7YMk4pTvY*/


        /*
        curl --request POST \
        --url https://preview.enterprise-auth.vip.nordstrom.com/v1/ausg0zujx3faqpGaA0h7/token \
        --header 'accept: application/json' \
        --header 'cache-control: no-cache' \
        --header 'content-type: application/x-www-form-urlencoded' \
        --data 'grant_type=authorization_code&client_id=0oazg9fb4xYjNM87o0h7&redirect_uri=https://perf-pos-order-search-pos.shared-lb.hydrogen.platform-nonprod.r53.nordstrom.net/login/oauth2/code/okta&code=93kM5l8l-Qy3xs2ziekiAmBMblUC6NHAoX7QShD8znk&code_verifier=RwQNI2IGYqAj9s6i_AUo5wLhGnLa5aDv1bHTqabStDc'

        */
    }
}
