package apiTesting.entities;

import java.util.Date;

public class BookingDates {
    private Date checkin;
    private Date checkout;

    public BookingDates() {
        // This constructor is only added for deserialization purposes
        // It should not be called directly
    }

    public BookingDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getCheckIn() {
        return checkin;
    }

    public void setCheckIn(Date checkIn) {
        this.checkin = checkIn;
    }

    public Date getCheckOut() {
        return checkout;
    }

    public void setCheckOut(Date checkOut) {
        this.checkout = checkOut;
    }
}
