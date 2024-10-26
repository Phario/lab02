package pl.pwr.ite.dynak.TowerBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//saves each step to a file and updates towers and buckets
public class ProcessScribe {
    private ArrayList<Double[]> writableData;
    public void saveToFile() throws IOException {
        try {
            File resultsFile = new File("results.txt");
            if (resultsFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter("results.txt");
                //write title row
                fileWriter.write("# nr kroku, nr miejsca, ilość piasku, numer wiaderka, wysokość miejsca po zbudowaniu");
                //write data to file

                fileWriter.close();
            }

        }
        catch (IOException e) {
            System.out.println("Failed to create the results file");
        }
    }
}
