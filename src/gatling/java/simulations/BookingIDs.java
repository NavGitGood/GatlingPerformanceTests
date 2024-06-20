package simulations;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.io.IOException;
import java.text.ParseException;

import static helper.RequestHelper.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class BookingIDs extends Simulation {

    private static final String PATH = "/booking";

    ScenarioBuilder scb = scenario("Get Booking IDs")
            .exec(http("make resquest for booking ids")
                    .get(PATH)
                    //.queryParamMap()
                    .check(status().is(200)));
    {
        try {
            setUp(scb.injectOpen(rampUsers(USER_COUNT).during(RAMP_DURATION))
                    .protocols(getHttpProtocol(BASE_URL))).maxDuration(MAX_DURATION)
                    .assertions(
                            forAll().responseTime().max().lt(MAX_RESPONSE_TIME),
                            global().successfulRequests().percent().gt(MIN_SUCCESS_PERCENTAGE)
                    );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
