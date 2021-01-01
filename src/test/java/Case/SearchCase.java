package Case;

import Tests.SearchTest;
import org.testng.annotations.Test;

public class SearchCase {
    SearchTest searchTest = new SearchTest("d1b66b77", "http://www.omdbapi.com/");

    @Test
    public void SearchCases() {
        searchTest.check_StatusCode200();
        searchTest.check_IsParamExisting("Title", "Harry Potter"); //check parameter
        // existence with Harry Potter Search
        searchTest.check_IsParamExisting("Year", "Harry Potter");
        searchTest.check_IsParamExisting("Released", "Harry Potter");
        searchTest.check_MovieExit("Harry Potter", "Harry Potter and the Deathly Hallows: Part 2");//check
        // movie exist
        searchTest.check_IdOfMovie("Harry Potter and the Deathly Hallows: Part 2"); //checking title result and id result equal
    }

}
