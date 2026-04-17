package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Files;

public class DifferTest {

    @Test
    public void testGenerateDiff() throws Exception {
        Path path1 = Path.of("src/test/resources/fixtures/file1.json").toAbsolutePath().normalize();;
        Path path2 = Path.of("src/test/resources/fixtures/file2.json").toAbsolutePath().normalize();;
        Path expectedPath = Path.of("src/test/resources/fixtures/result.txt").toAbsolutePath().normalize();;

        String expected = Files.readString(expectedPath).trim();
        String actual = Differ.generate(path1.toString(), path2.toString());

        assertEquals(expected, actual);
    }
}
