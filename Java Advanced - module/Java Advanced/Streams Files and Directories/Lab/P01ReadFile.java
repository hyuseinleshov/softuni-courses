package Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\UsenL\\Desktop\\Java Advanced - module\\Java Advanced - септември 2023\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileStream = new FileInputStream(path);

            int oneByte = fileStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
