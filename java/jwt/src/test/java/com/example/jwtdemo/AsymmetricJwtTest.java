package com.example.jwtdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricJwtTest {

    @Test
    //QTHQ
    void testAsymmetricJwtSigningAndVerification() throws NoSuchAlgorithmException {
        // 1. Generate an RSA Key Pair (Private for signing, Public for verification)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        String username = "asymmetricUser";

        // 2. Create and Sign the token using the PRIVATE KEY
        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60)) // 1 minute
                .signWith(keyPair.getPrivate()) // Sign with private key
                .compact();

        assertNotNull(token);
        System.out.println("Generated Asymmetric Token: " + token);

        // 3. Verify and Parse the token using the PUBLIC KEY
        Claims claims = Jwts.parser()
                .verifyWith(keyPair.getPublic()) // Verify with public key
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(username, claims.getSubject());
        System.out.println("Verified username: " + claims.getSubject());

        // 4. Demonstrate Failure with Wrong Key
        // Generate a different key pair
        KeyPair wrongKeyPair = keyPairGenerator.generateKeyPair();
        
        assertThrows(Exception.class, () -> Jwts.parser()
                .verifyWith(wrongKeyPair.getPublic()) // Try to verify with wrong public key
                .build()
                .parseSignedClaims(token), "Should throw exception when verifying with wrong public key");
    }
}
