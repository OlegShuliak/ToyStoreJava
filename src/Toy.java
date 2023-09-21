
import java.util.Random;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = new Random().nextInt(100 - weight);
    }

    public Toy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Toy toyFromString(String[] info) {
        return new Toy(Integer.parseInt(info[0]), info[1], Math.abs(Integer.parseInt(info[2])));
    }

    @Override
    public String toString() {
        return String.format("id = %d: %s (weight=%d)\n", id, name, weight);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.weight, o.weight);
    }
}
