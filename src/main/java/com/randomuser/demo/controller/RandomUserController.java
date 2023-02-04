package com.randomuser.demo.controller;

import com.randomuser.demo.response.RandomUserResp;
import com.randomuser.demo.service.RandomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RandomUserController {

    @Autowired
    private RandomUserService randomUserService;

    @GetMapping("/users/{seed}")
    public ResponseEntity<RandomUserResp> getRandomUser(@PathVariable(value="seed") String seed) throws Exception {
        return randomUserService.getRandomUser(seed);
    }
}
