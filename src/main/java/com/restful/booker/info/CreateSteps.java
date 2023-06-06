package com.restful.booker.info;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.AuthorisationPojo;
import com.restful.booker.model.BookingPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateSteps {

    @Step("Creating Token")
    public ValidatableResponse createToken(String username, String password) {
        AuthorisationPojo authorisationPojo = new AuthorisationPojo();
        authorisationPojo.setUsername(username);
        authorisationPojo.setPassword(password);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(authorisationPojo)
                .post(EndPoints.GET_AUTH)
                .then();
    }

    @Step("Create Booking with firstname {0}, lastname {1}, price {2}, depositpaid {3}, checkin date {4}, checkout date {5}, additionalneeds {6}")

    public ValidatableResponse createBooking(String firstname, String lastname, int totalprice, Boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        BookingPojo.BookingDates dates = new BookingPojo.BookingDates();
        dates.setCheckin(checkin);
        dates.setCheckout(checkout);
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds(additionalneeds);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post(EndPoints.GET_BOOKING)
                .then().log().all();
    }
}
