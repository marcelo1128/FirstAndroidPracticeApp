package test.restful;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MarceloMaldonado on 2/14/2018.
 */

public class Value {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("quote")
    private String quote;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
