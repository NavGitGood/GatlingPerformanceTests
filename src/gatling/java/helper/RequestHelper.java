package helper;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import static io.gatling.javaapi.http.HttpDsl.http;

public class RequestHelper {

    public static final int USER_COUNT = Integer.parseInt(PropertyHelper.getProperty("USERS", "test.users"));
    public static final int RAMP_DURATION = Integer.parseInt(PropertyHelper.getProperty("RAMP_DURATION", "test.rampDuration"));
    public static final int MAX_DURATION = Integer.parseInt(PropertyHelper.getProperty("MAX_DURATION", "test.maxDuration"));
    public static final int MAX_RESPONSE_TIME = Integer.parseInt(PropertyHelper.getProperty("MAX_RESPONSE_TIME", "test.maxResponseTime"));
    public static final double MIN_SUCCESS_PERCENTAGE = Double.parseDouble(PropertyHelper.getProperty("MIN_SUCCESS_PERCENTAGE", "test.minSuccessPercentage"));
    public static final String BASE_URL = PropertyHelper.getProperty("BASE_URL", "url.baseURL");

    public static HttpProtocolBuilder getHttpProtocol(String url) throws IOException, InterruptedException, ParseException {
        return http.baseUrl(url)
                //.header() // for authorization or other headers
                .disableFollowRedirect();
    }

    public static Map<String, Object> getNameFilterQueryParam() {
        return Map.ofEntries(
                Map.entry("firstname", "sally"),
                Map.entry("lastname", "brown")
        );
    }
}
