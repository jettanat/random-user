package com.ramdomuser.demo.controller;

import com.ramdomuser.demo.response.RandomUserResp;
import com.ramdomuser.demo.service.RandomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RandomUserController {

    @Autowired
    private RandomUserService randomUserService;

    @GetMapping("/users/{seed}")
    public ResponseEntity<RandomUserResp> getRandomUser(@PathVariable(value="seed", required = false) String seed) throws Exception {
        return randomUserService.getRandomUser(seed);
    }
}
