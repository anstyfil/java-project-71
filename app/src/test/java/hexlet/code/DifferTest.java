package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Files;

public class DifferTest {

    private static final Path EXPECTED_PATH = Path.of("src/test/resources/fixtures/result.txt").toAbsolutePath().normalize();;

    @Test
    public void testGenerateJsonDiff() throws Exception {
        Path path1 = Path.of("src/test/resources/fixtures/file1.json").toAbsolutePath().normalize();;
        Path path2 = Path.of("src/test/resources/fixtures/file2.json").toAbsolutePath().normalize();;

        String expected = Files.readString(EXPECTED_PATH).trim();
        String actual = Differ.generate(path1.toString(), path2.toString());

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlDiff() throws Exception {
        Path path1 = Path.of("src/test/resources/fixtures/file1.yml").toAbsolutePath().normalize();
        Path path2 = Path.of("src/test/resources/fixtures/file2.yml").toAbsolutePath().normalize();

        String expected = Files.readString(EXPECTED_PATH).trim();
        String actual = Differ.generate(path1.toString(), path2.toString()).trim();

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateStylishDiff() throws Exception {
        Path path1 = Path.of("src/test/resources/fixtures/file3.json").toAbsolutePath().normalize();
        Path path2 = Path.of("src/test/resources/fixtures/file4.json").toAbsolutePath().normalize();
        Path expectedPath = Path.of("src/test/resources/fixtures/resultStylish.txt").toAbsolutePath().normalize();

        String expected = Files.readString(expectedPath).trim();
        String actual = Differ.generate(path1.toString(), path2.toString()).trim();

        assertEquals(expected, actual);
    }
}
