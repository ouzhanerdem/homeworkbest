package Case;

import Tests.SearchTest;
import org.testng.annotations.Test;

public class SearchCase extends BaseCase {
    SearchTest searchTest = new SearchTest("d1b66b77", "http://www.omdbapi.com/");


    @Test(dataProvider = "dataForSearchGetCase")
    public void searchGetCases(String searchWord, String expectedResult) {
        searchTest.check_StatusCode200();
        searchTest.check_IsParamExisting("Title", searchWord); //check parameter
        // existence with Harry Potter Search
        searchTest.check_IsParamExisting("Year", searchWord);
        searchTest.check_IsParamExisting("Released", searchWord);
        searchTest.check_MovieExit(searchWord, expectedResult);//check
        // movie exist
        searchTest.check_IdOfMovie(expectedResult); //checking title result and id result equal
    }

}
