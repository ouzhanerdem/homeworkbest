package Tests;

public class SearchTest extends BaseTest{
    public SearchTest(String apiKey, String url) {
        super(apiKey, url);
    }

    public void check_StatusCode200(){
        check_StatusCode(200); //status code control
    }
    public void check_IsParamExisting(String nameParam, String searchWord){
        check_IsParamExist("t",nameParam, searchWord); //parameters control based on title search
    }
    public void check_MovieExit(String searchName, String expectedResult ){
        check_ValueOfParam("Title",searchName,expectedResult); //movie exist control
    }
    public void check_IdOfMovie(String searchTitle){
        String movieTitleResult = return_AnyValueBasedOnAnyParam("Title","Title",searchTitle);//taking
        // movie title based on title search
        String movieId = return_AnyValueBasedOnAnyParam("Title","imdbID",searchTitle); //taking
        //movie id based on title search
        String movieIdResult = return_AnyValueBasedOnAnyParam("imdbID","Title",movieId);//taking movie title
        //based on imdbID search
        areDataEqual(movieIdResult,movieTitleResult); //comparison of search results that based on title and imdbID
    }
}
