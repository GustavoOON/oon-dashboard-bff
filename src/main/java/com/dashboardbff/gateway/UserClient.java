package com.dashboardbff.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
@Component
public class UserClient {

    private String URL = "http://oontraccar.oonpayperuse.com.br:8080/traccar/user";
    private String ALL = "/all";

    @Autowired
    private final RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAllUsers() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("userType", "ADMIN");

        ObjectMapper mapper = new ObjectMapper();


        String url = UriComponentsBuilder.fromUriString(URL)
                .path(ALL)
                .build()
                .toString();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(url, HttpMethod.GET, entity, String.class);

            return responseEntity.getBody();

        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        return "";
    }
}
