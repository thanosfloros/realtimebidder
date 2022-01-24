import com.projectagora.DTO.*;
import com.projectagora.InvalidCountryException;
import com.projectagora.RealTimeBidderApp;
import com.projectagora.service.BidService;
import com.projectagora.service.CampaignService;
import com.projectagora.tools.Helper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.projectagora.tools.Helper.generateBid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = RealTimeBidderApp.class)
@ContextConfiguration
public class CampaignServiceTest {

    @Autowired
    private CampaignService campaignService;

    @Test
    void getCampaignsTest() {
        assertNotNull(campaignService.getCampaigns());
    }

    @Test
    void findCampaignsMatchingCriteriaGreeceTest() throws InvalidCountryException {
        List<Campaign> list =
                campaignService.findCampaignsMatchingCriteria("GR",
                        "Athens");
        assertNotNull(list);
        assertEquals(11, list.size());
    }

    @Test
    void findCampaignsMatchingCriteriaFranceTest() throws InvalidCountryException {
        List<Campaign> list =
                campaignService.findCampaignsMatchingCriteria("FR",
                        "Paris");
        assertNotNull(list);
        assertEquals(11, list.size());

    }

    @Test
    void findHighestPriceCampaignTest()  {
        assertNotNull(campaignService.findHighestPriceCampaign(campaignService.getCampaigns()));
    }

}
