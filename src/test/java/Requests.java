import Base.BasePage;
import io.restassured.http.Method;
import io.restassured.RestAssured;
import java.util.ArrayList;
import org.json.JSONObject;
import static Constants.Constant.*;


public class Requests extends BasePage {

    public String boardID="";
    public ArrayList cardID = new ArrayList();

    public void createBoard(String name){
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        pathParam.put("name", name);
        httpRequest = RestAssured.given();
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.POST,"/boards");
        this.boardID = response.jsonPath().getString("id");
    }

    public void createCard(String cardName){
        String list = random(this.boardID);
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        pathParam.put("name", cardName);
        pathParam.put("idList", list);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.POST,"/cards");
        this.cardID.add(response.jsonPath().getString("id"));
    }

    public void updateCard(String name, int Index){
        String cardID = (String) this.cardID.get(Index);
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        pathParam.put("name", name);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.PUT,"/cards/" + cardID);
        String isUpdatedName = response.jsonPath().getString("name");
    }

    public void deleteCardFirst(){
        String cardID = (String) this.cardID.get(0);
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.DELETE,"/cards/" + cardID);
    }

    public void deleteCardSecond(){
        String cardID = (String) this.cardID.get(1);
        JSONObject pathParam= new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.DELETE,"/cards/" + cardID);
    }

    public void deleteBoard(){
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(pathParam.toString());
        response = httpRequest.request(Method.DELETE,"/boards/" + boardID);
    }

}
