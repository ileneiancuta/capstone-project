package apiTesting.entities;

import java.util.List;

public class BookingIdResponseList {
    private List<BookingID> bookingList;

    public void setBookingList(List<BookingID> bookingList) {
        this.bookingList = bookingList;
    }

    public List<BookingID> getBookingList() {
        return bookingList;
    }

    @Override
    public String toString() {
        return "BookingIDList{" +
                "bookingList=" + bookingList +
                '}';
    }
}

