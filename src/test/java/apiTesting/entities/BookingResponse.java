package apiTesting.entities;

import java.util.List;

public class BookingResponse {

    private List<Booking> bookings;

    public BookingResponse() {
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
