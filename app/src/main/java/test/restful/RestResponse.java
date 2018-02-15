package test.restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by MarceloMaldonado on 2/14/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse {
    @JsonProperty("messages")
    private ArrayList<String> messages;
    @JsonProperty("result")
    private ArrayList<Result> result;


    public ArrayList<Result> getResult() {
        return result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString(){
        return "\nRestResponse : {" +
                "\nmessages : '" + messages + '\'' +
                '}';
    }


}
