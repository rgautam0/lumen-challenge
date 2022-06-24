package com.ctl.lumenchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctl.lumenchallenge.model.UserV;
import com.ctl.lumenchallenge.service.LumenChallengeService;

@RestController
public class LumenChallengeController {

    @Autowired
    private LumenChallengeService lumenChallengeService;

    /**
     * Get followers data by default URL http://localhost:9000/github/followers. You can get any number of followers by count
     * attribute like http://localhost:9000/github/followers?id=maddox&count=5
     *
     * @param id - It is GitHub user Id
     * @param count - number of followers to return
     * @return user
     */
    @GetMapping("/github/followers")
    public UserV getfollowers(@RequestParam(value = "id", defaultValue = "maddox") String id, @RequestParam(value = "count", defaultValue = "5") int count) {
        return lumenChallengeService.getfollowers(id, count);
    }

}
