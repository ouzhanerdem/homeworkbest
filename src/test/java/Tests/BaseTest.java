package Tests;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    private String apiKey;
    private String url;
    private String key = "apikey";


    public BaseTest(String apiKey, String url) { //constructor
        this.apiKey = apiKey;
        this.url = url;
    }

    public void check_StatusCode(int statusCode){ //checking status that is sent 200,201,300,400,500
        given()
                .param(key,apiKey)
                .get(url).then()
                .statusCode(statusCode);
    }
    public void check_ValueOfParam(String param, String searchValue, String expectedResult){ //checking value of a parameter
        //taking parameter, search value and expected result of the search based on search value
        String searchKey = return_ParamKey(param);
        given()
                .param(searchKey, searchValue)
                .param(key, apiKey)
                .get(url).then().body(param, equalTo(expectedResult));
    }
    public void check_IsParamExist(String searchKey,String param, String searchWord){//checking parameter is in body


        given()
                .param(searchKey,searchWord)
                .param(key, apiKey)
                .get(url).then().body("$",hasKey(param));
    }

    public String return_ParamKey(String param){ //returning of the parameter key based on parameter name to create url
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
        //returning a string value, search based on title return imdbId or vice versa
        String searchKey = return_ParamKey(requestParam);
        return given().param(searchKey, searchWord)
                .param(key, apiKey)
                .get(url).path(responseParamValue);
    }
    public void areDataEqual(String paramValue_1,String paramValue_2){
        //checking datas are equal
        Assert.assertEquals(paramValue_1,paramValue_2);
    }

}
