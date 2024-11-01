package pl.pwr.ite.dynak.dataprocessingutils;
import java.io.*;
import java.util.ArrayList;


import static pl.pwr.ite.dynak.dataprocessingutils.FileRequester.filePathRequest;

public class TipperLorry {

    public static ArrayList<Bucket> bucketLoader() throws IOException {
        try {
            File file = new File(filePathRequest("list of buckets"));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<Bucket> buckets = new ArrayList<>();
            reader.readLine(); //ignores the first line
            String data;
            while ((data = reader.readLine()) != null) {
                String[] numbers = data.split(", ");
                Bucket bucket = new Bucket(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Double.parseDouble(numbers[2]));
                buckets.add(bucket);
            }
            reader.close();
            return buckets;
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        return new ArrayList<>();
    }
}
