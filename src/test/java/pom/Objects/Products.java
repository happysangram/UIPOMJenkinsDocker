package pom.Objects;

import pom.utils.jacksonUtils;

import java.io.IOException;

public class Products {


    private int id;
    private String name;

    public Products() {
    }
    public Products(int id) throws IOException {
        Products[] product=jacksonUtils.DeserializeJsonGneric("Products.json",Products[].class);
        for (Products products:product){
            if(products.getId()==id){
                this.id=id;
                this.name=products.getName();
            }
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
