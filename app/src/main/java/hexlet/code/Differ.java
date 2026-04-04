package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class Differ {

    public static Map<String, Object> getData(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);

        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readValue(content, Map.class);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> file1 = getData(filePath1);
        Map<String, Object> file2 = getData(filePath2);
        return file1 + System.lineSeparator() + file2;
    }
}
