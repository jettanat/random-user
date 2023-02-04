package com.ramdomuser.demo.service;

import com.ramdomuser.demo.response.RandomUserResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RandomUserService {
//    private final RestTemplate restTemplate;
//
//    public RandomUserService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public ResponseEntity<RandomUserResp> getRandomUser(String seed) throws Exception {
        try {
            ResponseEntity<RandomUserResp> response;
            StringBuilder url = new StringBuilder("https://randomuser.me/api/");
            if (!seed.isEmpty()) {
                url.append("?seed=").append(seed);
            }
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<RandomUserResp> resp = restTemplate.getForEntity(url.toString(), RandomUserResp.class);
            if (resp.getStatusCode() == HttpStatus.OK) {
                response = ResponseEntity.ok(resp.getBody());
            } else {
                response = null;
            }

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
