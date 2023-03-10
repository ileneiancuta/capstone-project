package apiTesting.entities;

public class Booking {

    private String firstname;
    private String lastname;
    private Number totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;


    public Booking() {
        // This constructor is only added for deserialization purposes
        // It should not be called directly
    }

    public Booking(String firstname, String lastname, Number totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
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

    public Number getTotalPrice() {
        return totalprice;
    }
    public void setTotalPrice(Number totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositPaid() {
        return depositpaid;
    }
    public void setDepositPaid(Boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

    public BookingDates getBookingDates() {
        return bookingdates;
    }
    public void setAdditionalNeeds(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalNeeds() {
        return additionalneeds;
    }
    public void setAdditionalNeeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

}
