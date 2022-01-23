import com.projectagora.DTO.BidRequest;
import com.projectagora.DTO.BidResponse;
import com.projectagora.DTO.MobileApp;
import com.projectagora.DTO.MobileDevice;
import com.projectagora.RealTimeBidderApp;
import com.projectagora.service.BidService;
import com.projectagora.tools.Helper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static com.projectagora.tools.Helper.generateBid;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RealTimeBidderApp.class)
@ContextConfiguration
public class RealTimeBidderTest {

    @Autowired
    private BidService bidService;

    @Test
    void findBestBidTest() throws Exception {
        BidResponse bid = bidService.findBestBid(generateBid("ALL COUNTRIES"));
        assertNotNull(bid);
        assertNotNull(bid.getAdCreative());
        assertNotNull(bid.getCampaignId());
        assertTrue(bid.getCampaignId().startsWith("campaign"));
    }

    @Test
    void findBestBidGreeceTest() {
        BidResponse bid = bidService.findBestBid(generateBid("Greece"));
        assertNotNull(bid);
        assertNotNull(bid.getAdCreative());
        assertNotNull(bid.getCampaignId());
        assertTrue(bid.getCampaignId().startsWith("campaign"));
    }


}
