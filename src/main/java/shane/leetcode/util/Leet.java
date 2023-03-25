package shane.leetcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import static java.io.File.separator;

public class Leet {

    static public String readFileText(Class clazz, String filename) {
        try {
            String path = clazz.getPackage().getName().replaceAll("\\.", separator) + separator + filename;
            URL resource = clazz.getClassLoader().getResource(path);
            BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
