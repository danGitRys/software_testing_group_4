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
        assertEquals("W",SubscriptionRecommendationService.recommendModel(false, 2, false, 0));
    }

    
    @Test
    void testBasicSubscription(){
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

    /**
     * Possible Error when requiring UltraHd but the rest of the requirements is for a lower subscription, it recommends
     * the subscription from the lower tier
     */

    @Test
    void testNeedUpgradeToPremium(){
        assertEquals("P", SubscriptionRecommendationService.recommendModel(true, 2, true, 2));
    }
}
