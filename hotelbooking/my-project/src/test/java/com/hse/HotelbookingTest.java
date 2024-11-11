package com.hse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HotelbookingTest {

    @Test
    public void tempTest() {
        assertEquals(1, 1);
    }

    @Test
    public void testRoomTypesValid() {

        RoomType testRoom1 = RoomType.S;//test for single room
        RoomType testRoom2 = RoomType.D;//test for double room
        int testRoom3 = 0;//check if room type is int
        String testRoom4 = "T";//check if room type is char

        // Check for exception when room type is S
        assertDoesNotThrow(() -> Hotelbooking.calculateRoomPrice(4, testRoom1));

        // Check for exception when room type is D
        assertDoesNotThrow(() -> Hotelbooking.calculateRoomPrice(4, testRoom2));

        // Check for exception when room type is 0
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = Hotelbooking.class.getDeclaredMethod("calculateRoomPrice", int.class, RoomType.class);
            method.invoke(null, 4, testRoom3);
        });

        // Check for exception when room type is a wrong letter
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = Hotelbooking.class.getDeclaredMethod("calculateRoomPrice", int.class, RoomType.class);
            method.invoke(null, 4, testRoom4);
        });
        // Check for exception when room type is empty
        assertThrows(InvalidBookingException.class, () -> Hotelbooking.calculateRoomPrice(4, null));
    }

    @Test
    public void testDiscounts() throws InvalidBookingException {

        RoomType testRoom1 = RoomType.S;
        RoomType testRoom2 = RoomType.D;

        assertEquals(Hotelbooking.calculateRoomPrice(3, testRoom1), 60 * 1 * 3);//single room for 3 nights
        assertEquals(Hotelbooking.calculateRoomPrice(3, testRoom2), 70 * 1 * 3);//double room for 3 nights
        assertEquals(Hotelbooking.calculateRoomPrice(6, testRoom1), 60 * 1 * 6);//single room for 6 nights
        assertEquals(Hotelbooking.calculateRoomPrice(6, testRoom2), 70 * 1 * 6);//double room for 6 nights
        assertEquals(Hotelbooking.calculateRoomPrice(7, testRoom1), 60 * 0.9 * 7);//single room for 7 nights
        assertEquals(Hotelbooking.calculateRoomPrice(7, testRoom2), 70 * 0.9 * 7);//double room for 7 nights
        assertEquals(Hotelbooking.calculateRoomPrice(13, testRoom1), 60 * 0.9 * 13);//single room for 13 nights
        assertEquals(Hotelbooking.calculateRoomPrice(13, testRoom2), 70 * 0.9 * 13);//double room for 13 nights
        assertEquals(Hotelbooking.calculateRoomPrice(14, testRoom1), 60 * 0.8 * 14);//single room for 14 nights
        assertEquals(Hotelbooking.calculateRoomPrice(14, testRoom2), 70 * 0.8 * 14);//double room for 14 nights
    }

    @Test
    public void testExceptionThrownForNaNStay() {
        RoomType testRoom = RoomType.S;

        // Check for exception when nights is empty
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = Hotelbooking.class.getDeclaredMethod("calculateRoomPrice", int.class, RoomType.class);
            method.invoke(null, "ten", testRoom);
        });
    }

    @Test
    public void testExceptionThrownForEmptyStay() {
        RoomType testRoom = RoomType.S;

        // Check for exception when nights < 3
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = Hotelbooking.class.getDeclaredMethod("calculateRoomPrice", int.class, RoomType.class);
            method.invoke(null, null, testRoom);
        });
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
    public void testNoExceptionForValidShortStay() {
        RoomType testRoom = RoomType.S;

        // Ensure no exception is thrown for a valid stay (e.g., 4 nights)
        assertDoesNotThrow(() -> {
            double price = Hotelbooking.calculateRoomPrice(4, testRoom);
            assertEquals(60.0 * 4, price); // Price with no discount for 4 nights
        });
        // check for an exception that should be thrown if
    }

    public void testNoExceptionForValidLongStay() {
        RoomType testRoom = RoomType.S;

        // Ensure no exception is thrown for a valid stay (e.g., 7 nights)
        assertDoesNotThrow(() -> {
            double price = Hotelbooking.calculateRoomPrice(7, testRoom);
            assertEquals(60.0 * 0.9 * 7, price); // Price with 10% discount for 7 nights
        });
        // check for an exception that should be thrown if
    }

    public void testNoExceptionForValidFullStay() {
        RoomType testRoom = RoomType.S;

        // Ensure no exception is thrown for a valid stay (e.g., 14 nights)
        assertDoesNotThrow(() -> {
            double price = Hotelbooking.calculateRoomPrice(14, testRoom);
            assertEquals(60.0 * 0.8 * 14, price); // Price with 20% discount for 14 nights
        });
        // check for an exception that should be thrown if
    }
}
