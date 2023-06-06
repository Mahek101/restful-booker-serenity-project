package com.restful.booker.info;

import com.restful.booker.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteSteps {

    @Step("Deleting Booking information with bookingId: {0}")
    public ValidatableResponse deleteUser(String token, int bookingid) {
        return SerenityRest.given().log().all()
                .header("Cookie", "token=" + token)
                .pathParam("bookingId", bookingid)
                .when()
                .delete(EndPoints.DELETE_BY_ID)
                .then();
    }

    @Step("Getting student information with bookingId: {0}")
    public ValidatableResponse getUserbyId(String token, int bookingid) {
        return SerenityRest.given().log().all()
                .header("Cookie", "token=" + token)
                .pathParam("bookingId", bookingid)
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then();
    }
}
