package com.charterdemo.service;

import java.util.ArrayList;

import com.charterdemo.entity.Purchase;

public interface RewardsService {

    int calculateRewards(ArrayList<Purchase> pList);

    int getRewards(int userId);
}
