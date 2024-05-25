package JavaAdvancedRegularExam_18February2023.kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    private int size() {

        return getRegistry().size();
    }

    public boolean addChild(Child child) {

        if (size() < getCapacity()) {
            getRegistry().add(child);
            return true;
        }

        return false;
    }

    public boolean removeChild(String firstName) {

        boolean isRemovalSuccessful = false;

        for (int i = 0; i < size(); i++) {

            if (getRegistry().get(i).getFirstName().equals(firstName)) {
                getRegistry().remove(i);
                isRemovalSuccessful = true;
            }
        }

        return isRemovalSuccessful;
    }

    public int getChildrenCount() {

        return size();
    }

    public Child getChild(String firstName) {

        Child child = null;

        for (Child child1 : getRegistry()) {

            if (child1.getFirstName().equals(firstName)) {
                child = child1;
            }
        }

        return child;
    }

    public String registryReport() {

        Collections.sort(getRegistry(), Comparator
                .comparingInt(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Registered children in %s:", getName())).append(System.lineSeparator());
        sb.append("--").append(System.lineSeparator());

        getRegistry().forEach(child -> sb.append(child.toString()).append(System.lineSeparator()).append("--").append(System.lineSeparator()));

        return sb.toString();
    }

}
