package pom.Objects;

public class BillingAddress {
    private String fname;
    private String lname;
    private String address;
    private String city;
    private String zip;
    private String email;
    private String country;
    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public BillingAddress(String fname, String lname, String address, String city, String zip, String email, String country, String state) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.email = email;
        this.country = country;
        this.state = state;
    }



    public BillingAddress(){

    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
