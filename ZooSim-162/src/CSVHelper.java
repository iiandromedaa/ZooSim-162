import java.io.FileWriter;

import com.opencsv.CSVParserWriter;
import com.opencsv.CSVWriter;

public class CSVHelper {
    //i hope using a second class is allowed because there is no way im cramming all this extra stuff into the main file
    public static void export() {
        CSVWriter writer = new CSVWriter(new FileWriter("zoo.csv"), ",");
    }
}
