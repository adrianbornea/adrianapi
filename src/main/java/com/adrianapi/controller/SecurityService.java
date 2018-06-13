package com.adrianapi.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;


public interface SecurityService {

    String createToken(String subject, long ttlMillis);
    String getToken(String token);
}
