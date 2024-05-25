package Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\UsenL\\Desktop\\Java Advanced - module\\Java Advanced - септември 2023\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("write-to-file.txt");

        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;

            if (!symbols.contains(symbol)) {
                outputStream.write(oneByte);
            }

            oneByte = inputStream.read();
        }
    }
}
