import services.DayOne;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.AocUtils.getFilePath;

public class AdventOfCodeApplication {
    static void main() throws URISyntaxException, IOException {
        DayOne dayOne = new DayOne();
        dayOne.findPassword(getFilePath("/day1-1"));
    }
}
