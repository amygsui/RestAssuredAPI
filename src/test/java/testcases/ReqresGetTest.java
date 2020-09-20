package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReqresGetTest {

    @Test
    public void client_can_get_all_status_line() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";
        int expectedStatusCode = 200;
        String expectedProtocolVersion = "HTTP/1.1";

        // Test Steps

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);

        int actualStatusCode = response.getStatusCode();
        boolean actualProtocolVersion = response.getStatusLine().contains(expectedProtocolVersion);
        String actualStatusLine = response.getStatusLine();
        String allHeaderInfo = response.getHeaders().toString();

        System.out.println("Status line: " + actualStatusLine);
        System.out.println("HTTP Protocol Version: " + actualProtocolVersion);
        System.out.println("All header information: " + allHeaderInfo);

        // Test Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, expectedStatusCode);
        softAssert.assertTrue(actualProtocolVersion);
        softAssert.assertAll();

    }

    @Test
    public void client_can_get_all_headers() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";
        String expectedContentType = "application/json";
        String expectedServer = "cloudflare";
        String expectedConnection = "keep-alive";

        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);

        // You can also use response.headers().getValue("Content-Type");
        String actualContentType = response.getHeader("Content-Type");
        String actualServer = response.getHeader("Server");
        String actualConnection = response.getHeader("Connection");

        // Test Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualContentType.contains(expectedContentType));
        softAssert.assertTrue(actualServer.contains(expectedServer));
        softAssert.assertTrue(actualConnection.contains(expectedConnection));
        softAssert.assertAll();

    }

    @Test
    public void client_can_get_all_body() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";

        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);


        // Test Assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertAll();

    }
}
