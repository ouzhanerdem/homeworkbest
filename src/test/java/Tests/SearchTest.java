package Tests;

public class SearchTest extends BaseTest{
    public SearchTest(String apiKey, String url) {
        super(apiKey, url);
    }

    public void check_StatusCode200(){
        check_StatusCode(200);
    }
    public void check_IsParamExisting(String nameParam, String searchWord){
        check_IsParamExist("t",nameParam, searchWord);
    }
    public void check_MovieExit(String searchName, String expectedResult ){
        check_ValueOfParam("Title",searchName,expectedResult);
    }
    public void check_IdOfMovie(String searchTitle){
        String movieTitleResult = return_AnyValueBasedOnAnyParam("Title","Title",searchTitle);
        String movieId = return_AnyValueBasedOnAnyParam("Title","imdbID",searchTitle);
        String movieIdResult = return_AnyValueBasedOnAnyParam("imdbID","Title",movieId);
        areDataEqual(movieIdResult,movieTitleResult);
    }
}
