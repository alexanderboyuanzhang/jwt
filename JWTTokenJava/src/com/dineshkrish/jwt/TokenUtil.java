package com.dineshkrish.jwt;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {

	public static String getToken(final String scretKey) {

		String token = null;

		try {
			
			Algorithm algorithm = Algorithm.HMAC256("scretKey");
			Builder builder = JWT.create();
			token = builder.sign(algorithm);
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}

		return token;
	}

	public static void main(String[] args) {

		String scretKey = "dk";

		String token = TokenUtil.getToken(scretKey);

		System.out.println("The Token is : " + token);

	}

}