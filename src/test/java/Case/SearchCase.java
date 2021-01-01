package Case;
import Tests.*;
import org.testng.annotations.Test;

public class SearchCase {
    SearchTest searchTest = new SearchTest("d1b66b77","http://www.omdbapi.com/");

    @Test
    public void SearchCases(){
        searchTest.check_StatusCode200();
        searchTest.check_IsParamExisting("Title", "Harry Potter");
        searchTest.check_IsParamExisting("Year", "Harry Potter");
        searchTest.check_IsParamExisting("Released","Harry Potter");
        searchTest.check_MovieExit("Harry Potter","Harry Potter and the Deathly Hallows: Part 2");
        searchTest.check_IdOfMovie("Harry Potter and the Deathly Hallows: Part 2");
    }

}
