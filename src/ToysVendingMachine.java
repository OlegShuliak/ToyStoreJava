

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToysVendingMachine {

    private PriorityQueue<Toy> toys;

    public ToysVendingMachine(PriorityQueue<Toy> toys) {
        this.toys = toys;
    }

    public ToysVendingMachine() {
    }

    public PriorityQueue<Toy> getToys() {
        return toys;
    }

    public void setToys(PriorityQueue<Toy> toys) {
        this.toys = toys;
    }

    public void PutInMachine(List<String[]> infoToys){
        for (String[] infoToy: infoToys) {
            int i = Integer.parseInt(infoToy[2]);
            do {
                this.toys.add(new Toy().toyFromString(infoToy));
                i--;
            } while (i != 0);
        }
    }

    public Toy GetFromMachine(){
        return toys.poll();
    }

    @Override
    public String toString() {
        return String.format("%s", toys);
    }
}
