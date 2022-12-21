package apiTesting.entities;

import java.time.LocalDate;

public class BookingDates {
    public LocalDate checkin;
    public LocalDate checkout;

    public BookingDates() {
        // This constructor is only added for deserialization purposes
        // It should not be called directly
    }

    public BookingDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getCheckIn() {
        return checkin;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkin = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkout;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkout = checkOut;
    }
}
