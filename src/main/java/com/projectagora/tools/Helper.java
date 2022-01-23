package com.projectagora.tools;

import com.projectagora.DTO.BidRequest;
import com.projectagora.DTO.MobileApp;
import com.projectagora.DTO.MobileDevice;

import java.util.Random;

import static com.projectagora.tools.Constants.GREECE_LONGITUDE;

public class Helper {
    public static String getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return String.valueOf(random.nextInt(max - min) + min);
    }

    /**
     * @return a random number (for testing mostly)
     */
    public static Integer getRandomNumberUsingNextInt() {
        Random random = new Random();
        return (random.nextInt(1000 - 1) + 1);
    }

    /**
     * Method to retrieve a tag
     * @return a creative tag
     */
    public static String getCreative(){
        return "<script type=\"text/javascript\"> /*<![CDATA[*/ supp_key = \"001b3058ceb2d3effb32e1e548bee49c\"; supp_time = new Date().getTime(); supp_channel = \"\"; supp_code_format = \"ads-sync.js\"; supp_click = \"\"; supp_custom_params = {}; /*]]>*/ </script> <script type='text/javascript' src='//n101adserv.com/js/show_ads_supp.js?pubId=10471'></script>";
    }

    /**
     * Find location using latitude and longitude
     * @param latitude
     * @param longitude
     * @return String
     */
    public static String getLocation(double latitude, double longitude){
        String location = null;
        if(latitude==37.9838 && longitude==23.7275){
            location="Athens";
        }
        else location = Constants.ALL_LOCATIONS;
        return location;
    }

    public static BidRequest generateBid(String country){
        double longitude = 24.569;
        double latitude = 38.9838;
        if("Greece".equals(country)){
            longitude = Constants.GREECE_LONGITUDE;
            latitude = Constants.GREECE_LATITUDE;
        }
        MobileApp mobileApp = new MobileApp(Helper.getRandomNumberUsingNextInt(0, 100), "MyFitnessPal");
        MobileDevice mobileDevice =
                new MobileDevice(Helper.getRandomNumberUsingNextInt(0, 100), "Linux",
                        longitude, latitude, country);
        BidRequest bid = new BidRequest(Helper.getRandomNumberUsingNextInt(0, 100), mobileApp, mobileDevice);
        return bid;
    }
}
