package Lab;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> airplanes = new HashMap<>();

        airplanes.put("Airbus A320", 150);
        airplanes.put("Boeing 737", 130);

        airplanes.remove("Boeing 737");

//        for (Map.Entry<String, Integer> entry : airplanes.entrySet()) {
//            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
//        }

        int[] numbers = new int[]{2, 3, 4, 5, 6};

        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();

        int sum = Arrays.stream(numbers).sum();

        double average = Arrays.stream(numbers).average().getAsDouble();

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(5);
        numbersList.add(7);
        numbersList.add(3);
        numbersList.add(1);

        int min2 = numbersList.stream().mapToInt(Integer::intValue).min().getAsInt();

        String[] words = {"cat", "dog", "horse"};

        words = Arrays.stream(words).map(w -> w + "xD").toArray(String[]::new);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).filter(n -> n > 0).toArray();

        for (int num : nums) {
            System.out.printf("%d ", num);
        }
    }
}
