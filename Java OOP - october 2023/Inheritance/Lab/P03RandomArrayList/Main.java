package Lab.P03RandomArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList();

        randomArrayList.add(3);
        randomArrayList.add(5);
        randomArrayList.add(7);

        System.out.println(randomArrayList.getRandomElement());

    }

}
