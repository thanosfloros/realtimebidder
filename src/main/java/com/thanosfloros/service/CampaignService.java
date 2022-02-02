package com.thanosfloros.service;

import com.thanosfloros.DTO.Campaign;
import com.thanosfloros.InvalidCountryException;
import com.thanosfloros.tools.Constants;
import com.thanosfloros.tools.Helper;
import com.thanosfloros.tools.IsoUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    private final static Logger LOGGER = Logger.getLogger(CampaignService.class.getName());

    /**
     * Find all campaigns (here for demo purposes construct a list of
     *                 compaigns in a random fashion plus two specific ones)
     *                 Specs: Bidder retrieves all the available campaigns from its campaign pool.
     * @return list of campaings
     */
    public List<Campaign> getCampaigns()  {
        ArrayList<Campaign> list = new ArrayList();
        for(int i=0; i<10;i++){
            Campaign campaign =
                    new Campaign("campaign"+ Helper.getRandomNumberUsingNextInt(), Helper.getRandomNumberUsingNextInt(),
                            Helper.getCreative());
            list.add(campaign);
            LOGGER.info("found "+campaign.toString());
        }
        Campaign campaign =
                new Campaign("campaign"+ Helper.getRandomNumberUsingNextInt(),Helper.getRandomNumberUsingNextInt(),
                        Helper.getCreative(),
                        "GR", "Athens");
        Campaign campaign2 =
                new Campaign("campaign"+ Helper.getRandomNumberUsingNextInt(),Helper.getRandomNumberUsingNextInt(),
                        Helper.getCreative(),
                        Locale.FRANCE.getCountry(), "Paris");
        list.add(campaign);
        list.add(campaign2);
        return list;
    }

    /**
     * Get only campaigns matching the input criteria
     * Specs: Bidder filters out campaigns that do not match the targeting criteria.
     * @param country
     * @param location
     * @return List<Campaign>
     */
    public List<Campaign> findCampaignsMatchingCriteria(String country, String location) throws InvalidCountryException {
        if(!IsoUtil.isValidISOCountry(country))
            throw new InvalidCountryException();

        LOGGER.info("find campaigns matching country="+country+ " and location="+location);
        List<Campaign> campaigns = getCampaigns().stream().filter(in ->
                (in.getTargetedCountries().equals(country) || in.getTargetedCountries().equals(Constants.ALL_COUNTRIES))
                && (in.getTargetedLocations().equals(location) || in.getTargetedLocations().equals(Constants.ALL_LOCATIONS)))
                .collect(Collectors.toList());
        LOGGER.info("number of campaigns matching the criteria is: "+ campaigns.size());
        return campaigns;
    }

    /**
     * Find the campaign with the highest price or else throw
     * @param campaigns
     * @return campaign
     */
    public Campaign findHighestPriceCampaign(List<Campaign> campaigns)  {
        Campaign campaign = campaigns.stream().max(Comparator.comparing(Campaign::getPrice)).orElse(null);
        LOGGER.info("Found highest price campaign with price="+ (campaign!=null?campaign.getPrice():""));
        return campaign;
    }

}
