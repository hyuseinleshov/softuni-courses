package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArray = scanner.nextLine().split(" ");

        Random rnd = new Random();

        List<String> wordsRandomList = new ArrayList<>();

        int bound = wordsArray.length;

        for (int i = 0; i < wordsArray.length; i++) {
            int index = rnd.nextInt(bound);
            if (wordsRandomList.contains(wordsArray[index])) {
                i -= 1;
                continue;
            }
            wordsRandomList.add(wordsArray[index]);
        }
        for (int i = 0; i < wordsRandomList.size(); i++) {
            System.out.println(wordsRandomList.get(i));
        }
    }
}
