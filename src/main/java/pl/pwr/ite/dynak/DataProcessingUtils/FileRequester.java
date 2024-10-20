package pl.pwr.ite.dynak.DataProcessingUtils;

import java.util.Scanner;

public class FileRequester {
    protected static String filePathRequest(String fileType) {
        Scanner filePathRequest = new Scanner(System.in);
        System.out.println("Enter the filepath to the " + fileType + ": ");
        return filePathRequest.nextLine();
    }
}
