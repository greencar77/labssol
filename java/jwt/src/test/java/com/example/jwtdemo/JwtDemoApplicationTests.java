package com.example.jwtdemo;

import com.example.jwtdemo.security.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtDemoApplicationTests {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    void testJwtCreationAndValidation() {
        UserDetails userDetails = User.withUsername("testuser")
                .password("password")
                .authorities("USER")
                .build();

        String token = jwtUtils.generateToken(userDetails);
        assertNotNull(token);

        String username = jwtUtils.extractUsername(token);
        assertEquals("testuser", username);

        assertTrue(jwtUtils.validateToken(token, userDetails));
    }

}
