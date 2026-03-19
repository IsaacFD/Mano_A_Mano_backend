package org.manoamano.ecommerce.config;

import java.util.Base64;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

public class JwtFilter {

	public static final String secret = Base64.getEncoder().encodeToString(
			"Dicen#QueLaVidaSeTrataDeIntentarloHastaConseguirloPeroNadie!!!EsConscienteDeLoCansadoQueEsEso".getBytes());

	public static SecretKey getSigninKey() {
		byte[] keyBytes = Base64.getDecoder().decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}// getSigninKey

}// class JwtFilter