import static org.junit.jupiter.api.Assertions.*;

import de.hse.swb.swt.nametool.NameTool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class NameToolTest {
    private String name;
    private String surname;
    private String combName;

    @Test
    public void nameCombinationTest1() {//test with individual inputs under 15 chars, but combined name over 15 chars
        //setup phase start
        name="namename"; //name is 8 characters long
        surname="surnamesurname"; //surname is 14 chars long
        combName="namename surnam"; //what the combined name should be, 15 chars counting the whitespace
        //setup phase end
        //exercise phase start
        String temp=NameTool.newName(name,surname);//set the temp as the result of the name combination function
        //exercise phase end
        //verify stage start
        assertEquals(combName,temp);
        //verify stage end
    }

    @Test
    public void nameCombinationTest2(){//test with individual inputs under 15 chars and combined input under 15 chars
        //setup phase start
        name="name"; //name is 4 characters long
        surname="surname"; //surname is 7 chars long
        combName="name surname"; //what the combined name should be, 12 chars counting the whitespace
        //setup phase end
        //exercise phase start
        String temp=NameTool.newName(name,surname);//set the temp as the result of the name combination function
        //exercise phase end
        //verify stage start
        //verify using the temp by comparing to the expected result
        assertEquals(combName,temp);
        //verify stage end
    }

    //Teardown stage after each test, setting all the strings to null again
    @AfterEach
    public void teardown(){
        name=null;
        surname=null;
        combName=null;
    }
}
