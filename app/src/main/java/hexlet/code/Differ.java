package hexlet.code;

import java.util.Collections;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> file1 = Parser.parse(filePath1);
        Map<String, Object> file2 = Parser.parse(filePath2);

        List<String> keys = new ArrayList<>(file1.keySet());

        StringBuilder result = new StringBuilder();
        result.append("{\n");

        for (String key : file2.keySet()) {
            if (!keys.contains(key)) {
                keys.add(key);
            }
        }
        Collections.sort(keys);

        for (String key : keys) {
            boolean inFirst = file1.containsKey(key);
            boolean inSecond = file2.containsKey(key);

            Object value1 = file1.get(key);
            Object value2 = file2.get(key);

            if (inFirst && !inSecond) {
                result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");
            } else if (!inFirst && inSecond) {
                result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");
            } else if (Objects.equals(value1, value2)) {
                result.append("    ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");
            } else {
                result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");

                result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}