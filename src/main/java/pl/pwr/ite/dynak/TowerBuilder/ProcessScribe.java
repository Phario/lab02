package pl.pwr.ite.dynak.TowerBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//saves each step to a file and updates towers and buckets
public class ProcessScribe {
    private ArrayList<String> writableData = new ArrayList<>();
    public ProcessScribe() {
        writableData = new ArrayList<>();
    }
    public void saveToFile() throws IOException {
        try {
            File resultsFile = new File("results.txt");
            if (resultsFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter("results.txt");
                //write title row
                fileWriter.write("# nr kroku, nr miejsca, ilość piasku, numer wiaderka, wysokość miejsca po zbudowaniu");
                //write data to file
                for (String writableData : writableData) {
                    fileWriter.write("\n");
                    fileWriter.write(writableData);
                }
                fileWriter.close();
            }

        }
        catch (IOException e) {
            System.out.println("Failed to create the results file");
        }
    }
    public void addData(double[] reportData, int iterator) {
        double[] formattedData = {iterator+1,reportData[2],reportData[4],reportData[1]};
        String result = Arrays.stream(reportData).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        writableData.add(result);
    }
}
