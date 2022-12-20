package apiTesting.tests;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import apiTesting.entities.*;
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

        String token = given().
                spec(requestSpec).
                auth().preemptive().
                basic("admin", "password123").
                when().get("/token").
                then().extract().path("token");

        // Perform an HTTP GET on https://restful-booker.herokuapp.com/booking and store the first booking ID
        String bookingId = given().
                spec(requestSpec).
                auth().oauth2(token).
                when().get("/booking").
                then().statusCode(200).
                extract().path("bookingid");


        // Perform an HTTP GET on https://restful-booker.herokuapp.com/booking/:id and check that the first name and the last name are correct
        given().
                spec(requestSpec).
                auth().oauth2(token).
                when().get("/booking/${bookingId}").
                then().statusCode(200).
                assertThat().
                body("firstname", equalTo("John")).
                body("lastname", equalTo("Smith"));


        // Perform an HTTP POST that creates a new booking. Use POJOs and serialization. Check the response code to see if the POST was successful.
        Booking booking = new Booking(1992, "Ancuta", "Stafie", 5000, true);

        Booking booking1 = given().
                spec(requestSpec).
                and().
                body(booking).
                when().
                post("/customer").
                as(Booking.class);

        assertEquals("Ancuta", booking1.getFirstName());
        assertEquals("Stafie", booking1.getLastName());
    }
}
