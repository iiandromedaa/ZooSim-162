import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVHelper {
    //i hope using a second class is allowed because there is no way im cramming all this extra stuff into the main file


    public static void export() throws IOException {
        List<String[]> columns = new ArrayList<>();
        for (int i = 0; i < App.animalNames.length; i++) {
            String[] column = {App.animalNames[i], App.animalSpecies[i], App.animalAges[i], App.animalHabitats[i]};
            columns.add(column);
        }
        FileWriter fileWriter = new FileWriter("ZooSim-162/src/zoo.csv"); 
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        String[] headers = {"Names", "Species", "Ages", "Habitats"};
        csvWriter.writeNext(headers, false);
        for (String[] column : columns) {
            csvWriter.writeNext(column);
        }
    }
}
