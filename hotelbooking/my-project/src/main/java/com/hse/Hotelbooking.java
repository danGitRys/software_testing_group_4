package com.hse;

public class Hotelbooking {


    public static double calculateRoomPrice(int nights, RoomType type) throws InvalidBookingException {

        double price = 0.0;

        if (type == null) {
            throw new InvalidBookingException("Room type cannot be null");
        }

        if (nights < 3) {
            throw new InvalidBookingException("Stay needs to be longer then three days");
        }
        if (nights > 14) {
            throw new InvalidBookingException("Stay needs to be shorter then fourteen days");
        }

        if (type == RoomType.S) {

            price = 60.0;
        } else {
            price = 70.0;
        }

        if (nights == 14) {
            price = price * 0.8;

        } else if (nights >= 7) {
            price = price * 0.9;
        }

        return price * nights;
    }
}
