package com.restful.booker.info;

import com.restful.booker.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReadSteps {

    @Step("Get all booking ids")
    public ValidatableResponse getAllId() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_BOOKING)
                .then().statusCode(200);
    }

    @Step("Get Single Booking ID using id {0}")
    public ValidatableResponse getSingleId(int userId) {
        return SerenityRest.given().log().all()
                .pathParam("bookingId", userId)
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then().statusCode(200).log().all();
    }

    @Step("Get Single Booking by name using id {0}")
    public ValidatableResponse getSingleName(int userId) {
        return SerenityRest.given().log().all()
                .pathParam("user_id", userId)
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then().log().all()
                .statusCode(200)
                .extract()
                .path("findAll{it.bookingid == '" + userId + "'}.get(0)");
    }

    @Step("Get Ping Health Check")
    public ValidatableResponse getPing() {
        return SerenityRest.given().log().all()
                .when().get(EndPoints.PING)
                .then().statusCode(201).log().all();
    }
}
