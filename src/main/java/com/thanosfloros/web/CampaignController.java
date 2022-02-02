package com.thanosfloros.web;

import com.thanosfloros.DTO.Campaign;
import com.thanosfloros.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Campaigns API
 */
@RestController
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    /**
     * get all available campaigns
     * @return list of campaigns
     */
    @GetMapping("/campaigns")
    public List<Campaign> getCampaigns()  {
        return campaignService.getCampaigns();
    }

}