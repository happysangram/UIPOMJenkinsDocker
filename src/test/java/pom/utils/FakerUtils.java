package pom.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public Long fakerApiGeneration(){
        Faker faker=new Faker();
        return faker.number().randomNumber();
    }
}
