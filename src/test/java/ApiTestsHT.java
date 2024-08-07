import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.example.hometask.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTestsHT {

@Test
    void getSingleUser() throws JsonProcessingException {
        Response response = given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .log().all()
                .when()
                .get("/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();
        TotalResponse responseData;
        responseData = mapper.readValue(response.asString(), TotalResponse.class);
        Assert.assertEquals(responseData.getClass(), TotalResponse.class);
    }

@Test
    void postNewUser() throws JsonProcessingException {
    RegisterUser body1 = new RegisterUser("eve.holt@reqres.in", "pistol");
    Response response = given()
            .baseUri("https://reqres.in/api")
            .contentType("application/json")
            .body(body1)
            .log().all()
            .when()
            .post("/register")
            .then()
            .log().all()
            .statusCode(200)
            .extract().response();

    ObjectMapper mapper = new ObjectMapper();
    RegisterResponse responseData;
    responseData = mapper.readValue(response.asString(), RegisterResponse.class);
    Assert.assertEquals(responseData.getClass(), RegisterResponse.class);

}

    @Test
    void putUpdateUser() throws JsonProcessingException {
        UpdateRequest body2 = new UpdateRequest("morpheus", "zion resident");
        Response response = given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body(body2)
                .log().all()
                .when()
                .put("/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();
        UpdateResponse responseData;
        responseData = mapper.readValue(response.asString(), UpdateResponse.class);
        Assert.assertEquals(responseData.getClass(), UpdateResponse.class);

    }


    }






