package JavaAdvancedRetakeExam_12April2023.magazine;

import java.util.ArrayList;
import java.util.List;

public class Magazine {

    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        setType(type);
        setCapacity(capacity);
        setData();
    }

    public List<Cloth> getData() {
        return data;
    }

    public void setData() {
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addCloth(Cloth cloth) {

        if (getData().size() < capacity) {
            this.data.add(cloth);
        }

    }

    public boolean removeCloth(String color) {

        for (Cloth cloth : getData()) {
            if (cloth.getColor().equals(color)) {
                getData().remove(cloth);
                return true;
            }
        }

        return false;
    }

    public Cloth getSmallestCloth() {

        Cloth smallest = getData().stream()
                .min(Cloth::compareTo)
                .orElse(null);

        return smallest;
    }

    public Cloth getCloth(String color) {

        Cloth cloth = null;

        for (int i = 0; i < getData().size(); i++) {
            if (getData().get(i).getColor().equals(color)) {
                cloth = getData().get(i);
            }
        }

        return cloth;
    }

    public int getCount() {

        return getData().size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        for (Cloth cloth : getData()) {
            sb.append(cloth.toString()).append(System.lineSeparator());
        }

        return getType() + " JavaAdvancedRetakeExam_12April2023.magazine contains:\n" + sb.toString();
    }

}
