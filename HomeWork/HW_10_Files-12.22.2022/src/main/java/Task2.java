import org.json.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Task2 {

    private static String xmlLocation;



    public Task2()  {


    }

    public static void convert() {

//        xmlLocation = load


    }

    public static String loadProperties(String property){
        try (InputStream input = new FileInputStream("files\\system\\config.test")) {
            Properties prop = new Properties();
            prop.load(input);

            return prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
