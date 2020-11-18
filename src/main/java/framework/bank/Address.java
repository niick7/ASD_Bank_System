package framework.bank;

public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String Country;
    private int zipCode;

    public Address(String houseNumber, String street, String city, String state, String country, int zipCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        Country = country;
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return Country;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", Country='" + Country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
