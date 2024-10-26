package pl.pwr.ite.dynak.DataProcessingUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static pl.pwr.ite.dynak.DataProcessingUtils.FileRequester.filePathRequest;

public class TowerSpotMaker {

    public static ArrayList<TowerSpot> towerSpotMaker() throws IOException {
        try {
            File file = new File(filePathRequest("list of spots"));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<TowerSpot> towerSpots = new ArrayList<>();
            reader.readLine(); //ignores the first line
            String data;
            while ((data = reader.readLine()) != null) {
                String[] numbers = data.split(", ");
                towerSpots.add(new TowerSpot(Integer.parseInt(numbers[0]), Double.parseDouble(numbers[1])));
            }
            return towerSpots;
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        return null;
    }
}
