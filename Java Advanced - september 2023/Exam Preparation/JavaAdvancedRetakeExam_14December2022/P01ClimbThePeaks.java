package JavaAdvancedRetakeExam_14December2022;

import java.util.*;

public class P01ClimbThePeaks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> conqueredPeaks = new LinkedHashSet<>();

        Map<String, Integer> peaks = new LinkedHashMap<>();
        peaks.put("Vihren", 80);
        peaks.put("Kutelo", 90);
        peaks.put("Banski Suhodol", 100);
        peaks.put("Polezhan", 60);
        peaks.put("Kamenitza", 70);

        ArrayDeque<Integer> foodPortionsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(foodPortionsStack::push);

        ArrayDeque<Integer> staminaQuantitiesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(staminaQuantitiesQueue::offer);

        while ((!foodPortionsStack.isEmpty() && !staminaQuantitiesQueue.isEmpty()) && !peaks.isEmpty()) {

            int foodPortion = foodPortionsStack.peek();
            int stamina = staminaQuantitiesQueue.peek();

            int sum = foodPortion + stamina;

            int size = peaks.size();

            switch (size) {
                case 5:

                    if (sum >= peaks.get("Vihren")) {

                        peaks.remove("Vihren");

                        conqueredPeaks.add("Vihren");
                    }
                    break;
                case 4:

                    if (sum >= peaks.get("Kutelo")) {

                        peaks.remove("Kutelo");

                        conqueredPeaks.add("Kutelo");
                    }
                    break;
                case 3:

                    if (sum >= peaks.get("Banski Suhodol")) {

                        peaks.remove("Banski Suhodol");

                        conqueredPeaks.add("Banski Suhodol");
                    }
                    break;
                case 2:

                    if (sum >= peaks.get("Polezhan")) {

                        peaks.remove("Polezhan");

                        conqueredPeaks.add("Polezhan");
                    }
                    break;
                case 1:

                    if (sum >= peaks.get("Kamenitza")) {

                        peaks.remove("Kamenitza");

                        conqueredPeaks.add("Kamenitza");
                    }
                    break;
            }

            foodPortionsStack.pop();
            staminaQuantitiesQueue.poll();

        }

        if (peaks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {

            System.out.println("Conquered peaks:");

            for (String peak : conqueredPeaks) {

                System.out.println(peak);
            }

        }

    }

}
