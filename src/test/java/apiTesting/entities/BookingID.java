package apiTesting.entities;

public class BookingID
{
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