import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.example.pojo.ApiResponse;
import org.example.pojo.CreateUserBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test
    void getListOfUsers(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    void getListOfUsersCheckBody(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()));

    }

    @Test
    void getListOfUsersCheckBodyField(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()))
                .body("per_page", equalTo(6));

    }

    @Test
    void getListOfUsersCheckBodyData(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users/1")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()))
                .body("data.first_name", equalTo("George"));


    }

    @Test
    void getUserListWithPojo() throws JsonProcessingException {

        Response response = given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();
        ApiResponse responseData = mapper.readValue(response.asString(), ApiResponse.class);
        Assert.assertEquals(responseData.getTotal(), 12);
    }

    @Test
    void postCreateUser(){
        CreateUserBody body1 = new CreateUserBody("morpheus", "leader");

        given()
                .baseUri("https://reqres.in/api")
                .body(body1)
                .contentType("application/json")
                .log().all()
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201 )
                .body(not(emptyString()));
    }
}
