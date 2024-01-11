package Lab.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(format("get", 0))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName()));

        Method[] setters = Arrays.stream(methods)
                .filter(format("set", 1))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(m ->
                System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0]));


    }

    private static Predicate<Method> format(String set, int x) {
        return m -> m.getName().startsWith(set)
                && m.getParameterCount() == x;
    }

}
