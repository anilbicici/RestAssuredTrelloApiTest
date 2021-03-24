import Base.BaseTest;
import org.junit.Test;

import java.util.Random;

public class TestClass extends BaseTest {
    Requests api = new Requests();
    Random randoms = new Random();
    int cardSelection = randoms.nextInt(2);

    @Test
    public void Tests(){
        api.createBoard("Test");
        api.createCard("Mimari Otomasyon");
        api.createCard("X");
        api.updateCard("Tirtil Team", cardSelection);
        api.deleteCardFirst();
        api.deleteCardSecond();
        api.deleteBoard();
    }
}
