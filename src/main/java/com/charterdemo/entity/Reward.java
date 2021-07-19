package com.charterdemo.entity;

public class Reward {

    private int userId;

    private int points;

    public Reward(int userId, int points) {
	this.userId = userId;
	this.points = points;
    }

    public void addPoints(int points) {
	this.points = this.points + points;
    }
}
