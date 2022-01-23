package com.projectagora.DTO;

public class BidRequest {
    private String id;
    private MobileApp mobileApp;
    private MobileDevice mobileDevice;

    /**
     * @param id
     * @param mobileApp
     * @param mobileDevice
     */
    public BidRequest(String id, MobileApp mobileApp, MobileDevice mobileDevice) {
        this.id = id;
        this.mobileApp = mobileApp;
        this.mobileDevice = mobileDevice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MobileApp getMobileApp() {
        return mobileApp;
    }

    public void setMobileApp(MobileApp mobileApp) {
        this.mobileApp = mobileApp;
    }

    public MobileDevice getMobileDevice() {
        return mobileDevice;
    }

    public void setMobileDevice(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id='" + id + '\'' +
                ", mobileApp=" + mobileApp +
                ", mobileDevice=" + mobileDevice +
                '}';
    }
}
