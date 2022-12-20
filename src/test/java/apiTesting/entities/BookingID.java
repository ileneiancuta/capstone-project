package apiTesting.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingID {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("bookingid")
    private int bookingid;

    public void setId(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getId() {
        return bookingid;
    }

    @Override
    public String toString() {
        return "BookingID{" +
                "bookingid=" + bookingid +
                '}';
    }

}