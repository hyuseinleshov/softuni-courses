package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    public static class Song {
        String typeList;
        String name;
        String time;

        public Song (String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] songArray = scanner.nextLine().split("_");
            String typeList = songArray[0];
            String name = songArray[1];
            String time = songArray[2];

            Song song = new Song(typeList, name, time);

            songsList.add(song);
        }
        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song song : songsList) {
                System.out.println(song.name);
            }
        } else {
            for (Song song : songsList) {
                if (song.typeList.equals(command)) {
                    System.out.println(song.name);
                }
            }
        }
    }
}
