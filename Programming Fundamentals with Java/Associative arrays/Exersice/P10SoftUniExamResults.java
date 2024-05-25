package Exersice;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> pointsMap = new LinkedHashMap<>();
        Map<String, Integer> languageSubmissions = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] dataArray = input.split("-");
            String username = dataArray[0];
            if (dataArray.length == 3) {
                String language = dataArray[1];
                int points = Integer.parseInt(dataArray[2]);

                if (pointsMap.containsKey(username)) {
                    pointsMap.get(username).add(points);
                } else {
                    pointsMap.put(username, new ArrayList<>());
                    pointsMap.get(username).add(points);
                }

                if (languageSubmissions.containsKey(language)) {
                    languageSubmissions.put(language, languageSubmissions.get(language) + 1);
                } else {
                    languageSubmissions.put(language, 1);
                }
            } else {
                pointsMap.remove(username);
            }

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, List<Integer>> entry : pointsMap.entrySet()) {
            int mostPoints = -1;
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) > mostPoints) {
                    mostPoints = entry.getValue().get(i);
                }
            }
            System.out.printf("%s | %d%n", entry.getKey(), mostPoints);
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageSubmissions.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
        }
    }
}
