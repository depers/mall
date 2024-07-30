package cn.bravedawn;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/20 21:05
 */
public class PlaceOfBirth {

    private String city;
    private String country;
    public PlaceOfBirth(String city) {
        this.city=city;
    }

    public PlaceOfBirth( String country,String city) {
        this(city);
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String s) {
        this.city = s;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
