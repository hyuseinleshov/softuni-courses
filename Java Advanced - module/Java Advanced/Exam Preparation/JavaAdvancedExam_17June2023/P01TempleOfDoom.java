package JavaAdvancedExam_17June2023;

import java.util.*;
import java.util.stream.Collectors;

public class P01TempleOfDoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] tools = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] substances = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(tools).forEach(toolsQueue::offer);

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(substances).forEach(substancesStack::push);

        while (true) {

            int result = toolsQueue.peek() * substancesStack.peek();

            boolean isResolved = false;

            for (int i = 0; i < challenges.size(); i++) {

                if (challenges.get(i) == result) {
                    isResolved = true;
                    toolsQueue.poll();
                    substancesStack.pop();
                    challenges.remove(i);
                }
            }

            if (challenges.isEmpty()) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                break;
            }

            if (isResolved == false) {

                int tool = toolsQueue.poll();
                tool++;
                toolsQueue.addLast(tool);

                int substance = substancesStack.pop();
                substance--;
                if (substance != 0) {
                    substancesStack.addFirst(substance);
                }

            }

            if (substancesStack.isEmpty() || toolsQueue.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
            }

        }

        if (!toolsQueue.isEmpty()) {

            System.out.print("Tools: ");

            printCollection(toolsQueue);

        }

        if (!substancesStack.isEmpty()) {

            System.out.print("Substances: ");

            printCollection(substancesStack);
        }

        if (!challenges.isEmpty()) {

            System.out.print("Challenges: ");

            StringJoiner joiner = new StringJoiner(", ");
            challenges.forEach(item -> joiner.add(item.toString()));

            String result = joiner.toString();
            System.out.println(result);
        }

    }

    public static void printCollection(ArrayDeque<Integer> arrayDeque) {

        StringJoiner joiner = new StringJoiner(", ");
        arrayDeque.forEach(item -> joiner.add(item.toString()));

        String result = joiner.toString();
        System.out.println(result);

    }

}
