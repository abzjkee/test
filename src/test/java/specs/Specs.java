package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {

    private final static String URL = "https://reqres.in";
    public static final String HEADER = "x-api-key";
    public static final String VALUE = "reqres-free-v1";

    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .addHeader(HEADER, VALUE)
                .setContentType(ContentType.JSON)
                .build();
    }
}