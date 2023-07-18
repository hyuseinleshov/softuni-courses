package Exersice;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file = scanner.nextLine();

        String[] fileArray = file.split("\\\\");

        String fileData = fileArray[fileArray.length - 1];

        String fileName = fileData.split("[.]")[0];
        String fileExtension = fileData.split("[.]")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
