package com.charterdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charterdemo.service.RewardsService;

@RestController
public class RewardsController {

    @Autowired
    private RewardsService rewardsSvc;
    
    @GetMapping("/getRewards")
    public String getRewards(@RequestParam(value = "uId", defaultValue = "-1")
			     int userId) {
	System.out.println("GetRewards...");

	int points = rewardsSvc.getRewards(userId);
	System.out.println(String.format("Points for user %d: %d", userId,
					 points));
	return String.valueOf(points);
    }
}
