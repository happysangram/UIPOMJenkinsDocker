package pom.utils;

import pom.Objects.BillingAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class jacksonUtils {


    public static BillingAddress DeserializeJson(InputStream file, BillingAddress billingAddress) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, billingAddress.getClass());
    }

    public static <T> T DeserializeJsonGneric(String file, Class<T> T) throws IOException {
        InputStream is = jacksonUtils.class.getClassLoader().getResourceAsStream(file);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);
    }
}
