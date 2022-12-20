package apiTesting.tests;

import apiTesting.entities.Booking;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest
public class TestGetBooking {

    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }

    @Test
    public void testGetBookingId() {

        // Perform an HTTP GET on https://restful-booker.herokuapp.com/booking and store the first booking ID
        Booking booking =given().
                spec(requestSpec).
                auth().preemptive().
                basic("admin", "password123").
                when().get("/booking").
                as(Booking.class);

        System.out.println("abccc");
        System.out.println(booking.getBookingId());
        int bookingId = booking.getBookingId();

        // Perform an HTTP GET on https://restful-booker.herokuapp.com/booking/:id and check that the first name and the last name are correct
        given().
                spec(requestSpec).
                when().get("/booking/{booking.getBookingId()}").
                then().statusCode(200).
                assertThat().
                body("firstname", equalTo("John")).
                body("lastname", equalTo("Smith"));


        // Perform an HTTP POST that creates a new booking. Use POJOs and serialization. Check the response code to see if the POST was successful.
        Booking booking1 = new Booking(1992, "Ancuta", "Stafie", 5000, true);

        Booking booking2 = given().
                spec(requestSpec).
                and().
                body(booking1).
                when().
                post("/customer").
                as(Booking.class);

        assertEquals("Ancuta", booking1.getFirstName());
        assertEquals("Stafie", booking1.getLastName());
    }
}
