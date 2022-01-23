package com.projectagora.web;

import com.projectagora.DTO.Campaign;
import com.projectagora.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

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