package Exercise.P05Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < urls.size() - 1; i++) {

            String url = urls.get(i);

            if (url.matches("[^\\d]+")) {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
               sb.append("Invalid URL!").append(System.lineSeparator());
            }

        }

        String url = urls.get(urls.size() - 1);

        if (url.matches("\\D")) {
            sb.append(String.format("Browsing: %s!", url));
        } else {
            sb.append("Invalid URL!");
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size() - 1; i++) {

            String number = numbers.get(i);

            if (number.matches("\\d+")) {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }

        }

        String number = numbers.get(numbers.size() - 1);

        if (number.matches("\\d+")) {
            sb.append(String.format("Calling... %s", number));
        } else {
            sb.append("Invalid number!");
        }

        return sb.toString();
    }

}
