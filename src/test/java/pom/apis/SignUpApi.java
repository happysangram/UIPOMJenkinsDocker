package pom.apis;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pom.utils.ConfigLoader;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpApi {

    public Cookies getCookies() {
        return cookies;
    }

    private Cookies cookies;

    private Response getAccountUrl(){

        Cookies  cookies=new Cookies();
               Response response= given().
                baseUri("https://askomdch.com/").
                cookies(cookies).
                       log().all().
                when().
                get("account/").
                then().
                       log().all().
                extract().
                response();
               return response;
    }

    private String fetchIDusingJsoup(){
        Response response=getAccountUrl();
        Document doc= Jsoup.parse(response.body().prettyPrint());
        Element element=doc.selectFirst("#woocommerce-register-nonce");
        return  element.attr("value");
    }

    public Response register() throws IOException {
        Cookies cookies=new Cookies();
        Header header=new Header("content-Type","application/x-www-form-urlencoded");
        HashMap<String,String > formParams=new HashMap<>();
        formParams.put("email", ConfigLoader.getInstance().prop.getProperty("username"));
        formParams.put("password", ConfigLoader.getInstance().prop.getProperty("password"));
        formParams.put("username", ConfigLoader.getInstance().prop.getProperty("emailUname"));
        formParams.put("woocommerce-register-nonce",fetchIDusingJsoup());
        formParams.put("resgister", "Register");
        Response response= given().
                baseUri("https://askomdch.com/").
                cookies(cookies).
                header(header).
                formParams(formParams).  log().all().
                post("account/").
                then().
                log().all().
                extract().
                response();
        this.cookies=response.detailedCookies();
        return response;
    }

}
