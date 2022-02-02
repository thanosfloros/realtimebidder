import com.thanosfloros.DTO.BidResponse;
import com.thanosfloros.InvalidCountryException;
import com.thanosfloros.RealTimeBidderApp;
import com.thanosfloros.service.BidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static com.thanosfloros.tools.Helper.generateBid;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RealTimeBidderApp.class)
@ContextConfiguration
public class RealTimeBidderTest {

    @Autowired
    private BidService bidService;

    @Test
    void findBestBidTest() throws Exception {
        BidResponse bid = bidService.findBestBid(generateBid("GH"));
        assertNotNull(bid);
        assertNotNull(bid.getAdCreative());
        assertNotNull(bid.getCampaignId());
        assertTrue(bid.getCampaignId().startsWith("campaign"));
    }

    @Test
    void findBestBidGreeceTest() throws InvalidCountryException {
        BidResponse bid = bidService.findBestBid(generateBid("GR"));
        assertNotNull(bid);
        assertNotNull(bid.getAdCreative());
        assertNotNull(bid.getCampaignId());
        assertTrue(bid.getCampaignId().startsWith("campaign"));
    }

    @Test()
    void findBestBidNonExistingCountryTest() {
        InvalidCountryException thrown = Assertions.assertThrows(InvalidCountryException.class, () -> {
            bidService.findBestBid(generateBid("Non existing country"));
        }, "Invalid country");
        //Assertions.assertEquals("Invalid country", thrown.getMessage());
    }


}
