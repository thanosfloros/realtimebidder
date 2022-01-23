package com.projectagora.service;

import com.projectagora.DTO.BidRequest;
import com.projectagora.DTO.BidResponse;
import com.projectagora.DTO.Campaign;
import com.projectagora.tools.Helper;
import com.projectagora.web.BidController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BidService {

    private final static Logger LOGGER = Logger.getLogger(BidService.class.getName());

    @Autowired
    private CampaignService campaignService;

    public BidResponse findBestBid(BidRequest bid) {
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
