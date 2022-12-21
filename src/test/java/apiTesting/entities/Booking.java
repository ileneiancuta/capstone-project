package apiTesting.entities;

import java.time.LocalDate;

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

    public Booking(String firstName, String lastName, int totalPrice, boolean depositPaid) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositpaid = depositPaid;
        this.bookingdates = new BookingDates(LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));
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
