package test.restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("country")
    private String country;
    @JsonProperty("name")
    private String name;
    @JsonProperty("abbr")
    private String abbr;
    @JsonProperty("area")
    private String area;
    @JsonProperty("largest_city")
    private String largest_city;
    @JsonProperty("capital")
    private String capital;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLargest_city() {
        return largest_city;
    }

    public void setLargest_city(String largest_city) {
        this.largest_city = largest_city;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


    @Override
    public String toString() {
        return "result{" +
                "\n     id='" + id + '\'' +
                "\n     country='" + country + '\'' +
                "\n     name='" + name + '\'' +
                "\n     abbr='" + abbr + '\'' +
                "\n     area='" + area + '\'' +
                "\n     largest_city='" + largest_city + '\'' +
                "\n     capital='" + capital + '\'' +
                "}\n\n";
    }





}
