package com.projectagora.DTO;

public class MobileDevice {
    private String id;
    private String operatingSystem;
    private Double longitude;
    private Double latitude;
    private String country;

    public MobileDevice(String id, String operatingSystem, Double longitude,
                        Double latitude, String country) {
        this.id = id;
        this.operatingSystem = operatingSystem;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
