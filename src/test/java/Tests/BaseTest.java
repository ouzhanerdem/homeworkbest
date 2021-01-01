package Tests;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    private String apiKey;
    private String url;
    private String key = "apikey";


    public BaseTest(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    public void check_StatusCode(int statusCode){
        given()
                .param(key,apiKey)
                .get(url).then()
                .statusCode(statusCode);
    }
    public void check_ValueOfParam(String param, String searchValue, String expectedResult){
        String searchKey = return_ParamKey(param);
        given()
                .param(searchKey, searchValue)
                .param(key, apiKey)
                .get(url).then().body(param, equalTo(expectedResult));
    }
    public void check_IsParamExist(String searchKey,String param, String searchWord){


        given()
                .param(searchKey,searchWord)
                .param(key, apiKey)
                .get(url).then().body("$",hasKey(param));
    }

    public String take_StringValueOfParam(String param,String Title){
        return given().param("t",Title).param(key,apiKey).get(url).path(param);
    }

    public String return_ParamKey(String param){
        if (param.equals("Title")) {
            return "t";
        }
        else if(param.equals("imdbID")){
            return "i";
        }
        else {
            return "t";
        }
    }
    public String return_AnyValueBasedOnAnyParam(String requestParam, String responseParamValue, String searchWord){
        String searchKey = return_ParamKey(requestParam);
        return given().param(searchKey, searchWord)
                .param(key, apiKey)
                .get(url).path(responseParamValue);
    }
    public void areDataEqual(String paramValue_1,String paramValue_2){
        Assert.assertEquals(paramValue_1,paramValue_2);
    }

}
