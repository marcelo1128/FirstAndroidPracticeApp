package test.restful;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MarceloMaldonado on 2/9/2018.
 * Contracts: countriesTemplateRestful()->RestResponse()->Result
 * Ex. Restful json format looks like this:
    {
    "RestResponse" : {
            "messages" : [ "Total [55] records found." ],
            "result" : [ {
            "id" : 1,
            "country" : "USA",
            "name" : "Alabama",
            "abbr" : "AL",
            "area" : "135767SKM",
            "largest_city" : "Birmingham",
            "capital" : "Montgomery"
            },]
        }
    }
*/


//@JsonIgnoreProperties(ignoreUnknown = true)
public class countriesTemplateRestful {

    @JsonProperty("RestResponse")
    private test.restful.RestResponse RestResponse;


    public countriesTemplateRestful(){
        //empty constructor
    }

    public RestResponse getRestResponse() {

        return RestResponse;
    }

    @Override
    public String toString(){
        return "\nRestResponse : {" +
                "\n messages : '" + RestResponse.getMessages() + '\'' +
                "\n '" + this.getRestResponse().getResult().toString()+ '\'' +
                '}';
    }

}

