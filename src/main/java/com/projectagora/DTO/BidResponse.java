package com.projectagora.DTO;

public class BidResponse {
    private String id;
    private String campaignId;
    private String adCreative;
    private Integer price;

    public BidResponse() {
    }

    public BidResponse(String id, String campaignId, String adCreative,
                       Integer price) {
        this.id = id;
        this.campaignId = campaignId;
        this.adCreative = adCreative;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getAdCreative() {
        return adCreative;
    }

    public void setAdCreative(String adCreative) {
        this.adCreative = adCreative;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BidResponse{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", adCreative='" + adCreative + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
