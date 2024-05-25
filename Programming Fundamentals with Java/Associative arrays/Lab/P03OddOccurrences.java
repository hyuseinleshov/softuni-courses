package Lab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        List<String> wordsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                wordsList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", wordsList));
    }
}
