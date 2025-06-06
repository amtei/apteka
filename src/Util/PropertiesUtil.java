package Util;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;



public  final class  PropertiesUtil {
    private static final Properties PROPERTIES=new Properties();

    static {
        loadProperties();
    }
private PropertiesUtil(){

}
public static  String get(String key){
        return PROPERTIES.getProperty(key);
}
    private static void loadProperties() {
        try (var inputStream= PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {

            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
