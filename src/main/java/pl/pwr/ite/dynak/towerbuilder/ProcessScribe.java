package pl.pwr.ite.dynak.towerbuilder;

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
                fileWriter.write("# nr kroku, nr miejsca, numer wiaderka, wysokość miejsca, promień");
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
        //reportData: new radius, height, volume of sand used, spotNumber and bucketNumber
        //                             i       spotNo       bucketNo        height      radius
        double[] Data = {reportData[1],reportData[0]};
        int formattedSpotNumber = (int)reportData[3];
        int formattedBucketNumber = (int)reportData[4];
        String result = Arrays.stream(Data).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        String data = String.format("%s, %s, %s, %s", iterator,formattedSpotNumber, formattedBucketNumber, result);
        writableData.add(data);
    }
}
