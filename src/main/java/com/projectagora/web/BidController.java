package com.projectagora.web;

import com.projectagora.DTO.BidRequest;
import com.projectagora.DTO.BidResponse;
import com.projectagora.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class BidController {
    private final static Logger LOGGER = Logger.getLogger(BidController.class.getName());

    @Autowired
    private BidService bidService;

    @PostMapping("/bids")
    public BidResponse sendBidRequest(@RequestBody BidRequest bid) {
        LOGGER.info("Inbound request: "+bid.toString());
        BidResponse bidResponse = bidService.findBestBid(bid);
        return bidResponse;
    }


}