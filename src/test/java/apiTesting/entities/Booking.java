package apiTesting.entities;

import java.time.LocalDate;

public class Booking {

    private int bookingid;
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingDates;
    private String additionalneeds;


    public Booking() {
        // This constructor is only added for deserialization purposes
        // It should not be called directly
    }

    public Booking(int bookingId, String firstName, String lastName, int totalPrice, boolean depositPaid) {
        this.bookingid = bookingId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositpaid = depositPaid;
        this.bookingDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(1));
        this.additionalneeds = "Testing - additional notes";
    }

    public int getBookingId() {
        return bookingid;
    }
    public void setBookingId(int bookingId) {
        this.bookingid = bookingId;
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
