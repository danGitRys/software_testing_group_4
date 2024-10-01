package de.hse.swb.swt;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.hse.swb.swt.streamflix.SubscriptionRecommendationService;
public class SubscriptionRecommendationServiceTest {
    
    /**
     * Dummy Test to test if Junit works
     */

    

    @Test
    void  testStandardSubscriptionWithAds(){
        assertEquals("W",SubscriptionRecommendationService.recommendModel(false, 0, false, 0));
    }

    
    @Test
    void testBasicSubscripton(){
        assertEquals("B",SubscriptionRecommendationService.recommendModel(true, 2, false, 1));
    }

    @Test
    void testStandardSubscription(){
        assertEquals("S", SubscriptionRecommendationService.recommendModel(true, 2, false, 2));
    }

    @Test
    void testPremiumSubscription(){
        assertEquals("P",SubscriptionRecommendationService.recommendModel(true, 4, true, 6));
    }

}
