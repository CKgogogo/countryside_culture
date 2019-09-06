package com.countryside_culture.entity;

public class rating extends ratingKey {
    private Double rating;

    private Integer rateTime;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRateTime() {
        return rateTime;
    }

    public void setRateTime(Integer rateTime) {
        this.rateTime = rateTime;
    }
}