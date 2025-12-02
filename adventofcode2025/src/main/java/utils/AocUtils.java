package utils;

import services.DayOne;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AocUtils {
    public static Path getFilePath(String name) throws URISyntaxException {
        var path = DayOne.class.getResource(name);
        assert path != null;
        return Paths.get(path.toURI());
    }
}
