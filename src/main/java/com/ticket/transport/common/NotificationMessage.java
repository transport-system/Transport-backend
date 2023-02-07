package com.ticket.transport.common;

public class NotificationMessage {
    //UPDATE
    public final static String UPDATE_1ST_MESSAGE = "You are having an ongoing booking. Booking ID is: ";
    public final static String UPDATE_2RD_MESSAGE = "Booking is updated recently. Please checking your email. Booking ID is: ";

    //CONFIRM
    public final static String CONFIRM_BOOKING_SUCCESS = "A booking has been recently confirmed! Booking ID is: ";
    public final static String CONFIRM_BOOKING_FAIL = "A booking has been recently rejected! Booking ID is: ";

    //CREATE
    public final static String CREATE_BOOKING_SUCCESS = "An booking has been recently created! Booking ID is: ";
    public final static String CREATE_BOOKING_FAIL = "The booking creating fail";
    public final static String REJECT_BOOKING = "Your booking is rejected. Notification is from company: ";
}
