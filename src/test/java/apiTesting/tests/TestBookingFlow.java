package apiTesting.tests;

import apiTesting.entities.Booking;
import apiTesting.entities.BookingID;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest
public class TestBookingFlow {

    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }

    @Test
    public void testBookingFlow() {

        /*******************************************************
        Perform an HTTP GET on https://restful-booker.herokuapp.com/booking
        and store the first booking ID
        *******************************************************/
        Response response = given().
                spec(requestSpec).
                auth().preemptive().
                basic("admin", "password123").
                when().get("/booking");

        List<BookingID> bookingIds = response.getBody().as(new TypeRef<>() {});



        /*******************************************************
        Perform an HTTP GET on https://restful-booker.herokuapp.com/booking/:id
        and check that the first name and the last name are correct
        *******************************************************/
        given().
                spec(requestSpec).
                pathParam("bookingid", bookingIds.stream().findFirst().get().getId()).
                when().get("/booking/{bookingid}").
                then().statusCode(200).
                assertThat().
                body("$", not(hasValue(nullValue())));
//                body("firstname", equalTo("Josh")).
//                body("lastname", equalTo("Allen"));



        /*******************************************************
         Perform an HTTP POST that creates a new booking.
         Use POJOs and serialization.
         Check the response code to see if the POST was successful.
         *******************************************************/

        Booking booking1 = new Booking("Ancuta", "Stafie", 5000, true);

        Response bookingResponse =
                given().
                spec(requestSpec).
                and().
                body(booking1).
                when().
                post("/booking");

        System.out.println("booking1");
        printObject(booking1);





        assertEquals(200, bookingResponse.getStatusCode());
        assertEquals("Ancuta", bookingResponse.as(Booking.class).getFirstName());
        assertEquals( "Stafie", bookingResponse.as(Booking.class).getLastName());

    }


    public void printObject(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(object));
    }

}
