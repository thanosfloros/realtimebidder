package com.thanosfloros.DTO;

public class Campaign {
    private String id;
    private Integer price;
    private String adCreative;
    private String targetedCountries = "ALL COUNTRIES";
    private String targetedLocations = "ALL LOCATIONS";

    public Campaign(String id, Integer price, String adCreative,
                    String targetedCountries, String targetedLocations) {
        this.id = id;
        this.price = price;
        this.adCreative = adCreative;
        this.targetedCountries = targetedCountries;
        this.targetedLocations = targetedLocations;
    }

    public Campaign(String id, Integer price, String adCreative) {
        this.id = id;
        this.price = price;
        this.adCreative = adCreative;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAdCreative() {
        return adCreative;
    }

    public void setAdCreative(String adCreative) {
        this.adCreative = adCreative;
    }

    public String getTargetedCountries() {
        return targetedCountries;
    }

    public void setTargetedCountries(String targetedCountries) {
        this.targetedCountries = targetedCountries;
    }

    public String getTargetedLocations() {
        return targetedLocations;
    }

    public void setTargetedLocations(String targetedLocations) {
        this.targetedLocations = targetedLocations;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", adCreative='" + adCreative + '\'' +
                ", targetedCountries='" + targetedCountries + '\'' +
                ", targetedLocations='" + targetedLocations + '\'' +
                '}';
    }
}
