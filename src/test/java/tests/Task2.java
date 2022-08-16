package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class Task2 extends TestInit {

    @Test(groups = "API")
    public void checkGetRequest() {
        RestAssured.baseURI = "http://api.ipstack.com/";
        RestAssured
                .given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .get("134.201.250.155?access_key=91ddf990fd94e8a4e7dcfd21c5cf1775")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(groups = "API")
    public void checkParse() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        RestAssured.baseURI = "http://api.ipstack.com/";

        Assert.assertEquals(decimalFormat.format(getValueKey("latitude")), "34,07");
        Assert.assertEquals(decimalFormat.format(getValueKey("longitude")), "-118,24");
    }

    public float getValueKey(String value) {
        return RestAssured
                .given()
                .get("134.201.250.155?access_key=91ddf990fd94e8a4e7dcfd21c5cf1775")
                .getBody()
                .jsonPath()
                .get(value);
    }
}
