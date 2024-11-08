package com;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

public class HotelbookingTest {
    
    @Test 
    public void tempTest(){
        assertEquals(1,1);
    }

    @Test
    public void testSingleShort(){

        RoomType testRoom = RoomType.S;

        try {
            assertEquals(Hotelbooking.calculateRoomPrice(4, testRoom.D), 70);
        } catch (InvalidBookingException e) {
            fail("Exception should not be thrown for valid booking");
        }
    }

    @Test
    public void testExceptionThrownForShortStay() {
        RoomType testRoom = RoomType.S;

        // Check for exception when nights < 3
        assertThrows(InvalidBookingException.class, () -> {
            Hotelbooking.calculateRoomPrice(2, testRoom);
        });
    }

    @Test
    public void testExceptionThrownForLongStay() {
        RoomType testRoom = RoomType.S;

        // Check for exception when nights > 14
        assertThrows(InvalidBookingException.class, () -> {
            Hotelbooking.calculateRoomPrice(15, testRoom);
        });
    }

    @Test
    public void testNoExceptionForValidStay() {
        RoomType testRoom = RoomType.S;

        // Ensure no exception is thrown for a valid stay (e.g., 7 nights)
        assertDoesNotThrow(() -> {
            double price = Hotelbooking.calculateRoomPrice(7, testRoom);
            assertEquals(60.0 * 0.9, price); // Price with 10% discount for 7 nights
        });
    }
}
