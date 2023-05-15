package pom.tests;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.Objects.ProductPojo;
import pom.Objects.Sample;
import pom.base.BaseTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Dummy extends BaseTest {
    private Path path;
    private String s;
    JsonReader reader;
    Gson gson;
    ProductPojo pojo;
    @BeforeClass
    public void demo() throws IOException {
        gson=new Gson();
        reader = new JsonReader(new FileReader("/Users/sangram.das/GIT/POMUIAutomation/src/test/resources/product.json"));
        pojo=gson.fromJson(reader,ProductPojo.class);

    }

    @Test( dataProvider ="dataProviderValue")
    public void addToCartUsingDataProvider(Sample sample){
        System.out.println(sample.getName());
        System.out.println(sample.getId());
    }

    @DataProvider(name = "dataProviderValue")
    private Object[][] getproducts() throws IOException {

//        Stream<Sample> ss=pojo.getSample().stream();
//        Stream<Object> ss1=ss.map(var -> new Object[] { var });
//        Object[][] ss2=ss1.toArray(Object[][]::new);

        return  pojo.getSample().stream()
                .map(var -> new Object[] { var })
                .toArray(Object[][]::new);

    }
}
