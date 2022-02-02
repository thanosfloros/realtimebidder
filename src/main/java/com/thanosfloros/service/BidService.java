package com.thanosfloros.service;

import com.thanosfloros.DTO.BidRequest;
import com.thanosfloros.DTO.BidResponse;
import com.thanosfloros.DTO.Campaign;
import com.thanosfloros.InvalidCountryException;
import com.thanosfloros.tools.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BidService {

    private final static Logger LOGGER = Logger.getLogger(BidService.class.getName());

    @Autowired
    private CampaignService campaignService;

    /**
     * Find best bid using the incoming request
     * @param bid
     * @return
     * @throws InvalidCountryException
     */
    public BidResponse findBestBid(BidRequest bid) throws InvalidCountryException {
        List<Campaign> campaigns =
                campaignService.findCampaignsMatchingCriteria(bid.getMobileDevice().getCountry(),
                Helper.getLocation(bid.getMobileDevice().getLatitude(),
                        bid.getMobileDevice().getLongitude()));

        Campaign highestPriceCampaign =
                campaignService.findHighestPriceCampaign(campaigns);
        BidResponse bidResponse = null;
        if(highestPriceCampaign!=null){
            bidResponse = new BidResponse(bid.getId(), highestPriceCampaign.getId(),
                    highestPriceCampaign.getAdCreative(),
                    highestPriceCampaign.getPrice());
        }
        return bidResponse;
    }
}
