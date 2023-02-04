package com.randomuser.demo.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.randomuser.demo.response.RandomUserResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RandomUserService {

    public ResponseEntity<RandomUserResp> getRandomUser(String seed) throws Exception {
        try {
            ResponseEntity<RandomUserResp> response;
            StringBuilder url = new StringBuilder("https://randomuser.me/api/");
            if (!seed.isEmpty()) {
                url.append("?seed=").append(seed);
            }
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> resp = restTemplate.getForEntity(url.toString(), String.class);
            if (resp.getStatusCode() == HttpStatus.OK) {
                RandomUserResp randomUserResp = new RandomUserResp();
                final Gson gson = new Gson();
                JsonObject body = gson.fromJson(resp.getBody(), JsonObject.class);
                JsonObject results = body.get("results").getAsJsonArray().get(0).getAsJsonObject();
                JsonObject name = results.get("name").getAsJsonObject();

                randomUserResp.setFirstName(name.get("first").getAsString());
                randomUserResp.setLastName(name.get("last").getAsString());
                randomUserResp.setGender(results.get("gender").getAsString());
                randomUserResp.setEmail(results.get("email").getAsString());


                response = ResponseEntity.ok(randomUserResp);
            } else {
                response = null;
            }

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
