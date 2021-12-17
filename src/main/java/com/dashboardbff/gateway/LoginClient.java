package com.dashboardbff.gateway;


import com.dashboardbff.request.LoginRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class LoginClient {

    private String URL = "http://oontraccar.oonpayperuse.com.br:8080/traccar/authenticator";

    @Autowired
    private final RestTemplate restTemplate;

    public LoginClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void authenticator(LoginRequest loginRequest) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(loginRequest);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(URL, HttpMethod.POST, entity, String.class);
    }
}
