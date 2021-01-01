package Case;

import org.testng.annotations.DataProvider;

public class BaseCase {

    @DataProvider(name = "dataForSearchGetCase")
    public Object[] dataForGet(){
        String[][] objects = {
                {"Harry Potter","Harry Potter and the Deathly Hallows: Part 2"}
        };
        return objects;

    }
           
                

}
