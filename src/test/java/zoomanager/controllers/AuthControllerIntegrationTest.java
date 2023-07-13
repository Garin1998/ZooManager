package zoomanager.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import zoomanager.controllers.requests.RegisterReq;
import zoomanager.jpa.UserRepository;

import java.util.StringJoiner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static zoomanager.constants.ControllerPathConstants.AUTH_URL;
import static zoomanager.constants.ErrorMessageConstants.MUST_BE_FILLED;

@ActiveProfiles({"dev", "integration"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-dev.yaml")
class AuthControllerIntegrationTest {

    RegisterReq request;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp(@Value("${server.port}") int port) {
        request = RegisterReq.builder().name("test_user").password("1a2B3c@d").firstName("Jan").lastName("Kowalski").email("test@gmail.com").build();

        RestAssured.baseURI = "http://localhost:" + port;
        RestAssured.basePath = AUTH_URL;
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
        userRepository.deleteAll();
    }

    @Test
    void givenValidRequestWhenRegisterThenReturnStatus200AndCheckIfBodyIsNotNullValue() {
        given().contentType(ContentType.JSON).body(request).when().post("/register").prettyPeek().then().statusCode(HttpStatus.OK.value()).contentType(ContentType.JSON).body("token", notNullValue());

    }

    @Test
    void givenBlankRequestWhenRegisterThenThrowAllConstraintViolationsAndReturn401() throws JSONException {
        request = RegisterReq.builder()
                .name("")
                .password("")
                .firstName("")
                .lastName("")
                .email("")
                .build();

        StringJoiner passwordValidationConstraints = new StringJoiner(" ");
        passwordValidationConstraints
                .add("Password must be 8 or more characters in length.")
                .add("Password must contain 1 or more uppercase characters.")
                .add("Password must contain 1 or more lowercase characters.")
                .add("Password must contain 1 or more digit characters.")
                .add("Password must contain 1 or more special characters.");

        JSONObject expectedJson = new JSONObject();

        expectedJson.put("name", MUST_BE_FILLED.getMessage());
        expectedJson.put("password", passwordValidationConstraints.toString());
        expectedJson.put("firstName", MUST_BE_FILLED.getMessage());
        expectedJson.put("lastName", MUST_BE_FILLED.getMessage());
        expectedJson.put("email", MUST_BE_FILLED.getMessage());

        String response =
        given()
                .contentType(ContentType.JSON)
                .body(request)
        .when()
                .post("/register")
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .asString();

        JSONObject actualResponse = new JSONObject(response);

        JSONAssert.assertEquals(actualResponse, expectedJson, JSONCompareMode.LENIENT);

    }

    @Test
    void authenticate() {
    }
}