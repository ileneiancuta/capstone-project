package apiTesting.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingID {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("bookingid")
    private int bookingId;

    public void setId(int bookingid) {
        this.bookingId = bookingid;
    }

    public int getId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "BookingID{" +
                "bookingid=" + bookingId +
                '}';
    }

}