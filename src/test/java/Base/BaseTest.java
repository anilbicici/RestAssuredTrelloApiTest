package Base;
import io.restassured.RestAssured;
import org.junit.Before;


public class BaseTest {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.trello.com/1";
    }

}
