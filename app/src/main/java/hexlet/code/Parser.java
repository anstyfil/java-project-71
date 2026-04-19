package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);

        String extension = getExtension(filePath);
        ObjectMapper mapper = switch(extension) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception("Unsupported extension: " + extension);
        };
        return mapper.readValue(content, Map.class);
    }

    private static String getExtension(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(dotIndex + 1);
    }
}
