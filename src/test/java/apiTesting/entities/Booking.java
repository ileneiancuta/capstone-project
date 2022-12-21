package apiTesting.entities;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.util.Date.from;

public class Booking {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;


    public Booking() {
        // This constructor is only added for deserialization purposes
        // It should not be called directly
    }

    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = new BookingDates(from(Instant.now()), from(Instant.now().plus(5, ChronoUnit.DAYS)));
        this.additionalneeds = "Testing - additional notes";
    }


    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }
    public void seLastName(String lastName) {
        this.lastname = lastName;
    }

    public int getTotalPrice() {
        return totalprice;
    }
    public void setTotalPrice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean getDepositPaid() {
        return depositpaid;
    }
    public void setDepositPaid(boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

}
