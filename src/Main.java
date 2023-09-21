
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ToysVendingMachine machine = new ToysVendingMachine(new PriorityQueue<>());

        System.out.println("Введите количество видов игрушек, которое вы хотите поместить в автомат:");
        int qtyToys;
        do{
            try {
                qtyToys = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e){
                System.out.println("Неверно введено количество, повторите попытку ввода:");
            }
        } while (true);


        File toysBefore = new File("D:\\GeekBrains\\ToyStoreJava\\src\\ToysBeforeGetting.txt");
        FileWriter start = new FileWriter(toysBefore);

        List<String[]> infoToys = insertInfo(qtyToys);
        machine.PutInMachine(infoToys);
        for (Toy toy: machine.getToys()) {
            start.write(toy.toString());
        }
        start.flush();

        File prise = new File("D:\\GeekBrains\\ToyStoreJava\\src\\YourPrise.txt");
        FileWriter play = new FileWriter(prise);

        int count = 10;

        do {
            play.write(machine.GetFromMachine().toString());
            count--;
        } while (count > 0);
        play.flush();

        File toysAfter = new File("D:\\GeekBrains\\ToyStoreJava\\src\\ToysAfterGetting.txt");
        FileWriter finish = new FileWriter(toysAfter);
        for (Toy toy: machine.getToys()) {
            finish.write(toy.toString());
        }
        finish.flush();
    }

    public static List<String[]> insertInfo (int qtyToys){
        List<String[]> infoToys = new ArrayList<>(qtyToys);

        for (int i = 0; i < qtyToys; i++) {
            System.out.printf("Введите данные %d-й игрушки через пробел (Наименование 'вес'):\n", i + 1);
            System.out.println("(вес учитывает количество одного вида игрушек в % от вметительности автомата)");
            do {
                String[] info = (String.format("%d ", i + 1) + scanner.nextLine()).split(" ");
                try {
                    Toy toy = new Toy().toyFromString(info);
                    infoToys.add(info);
                    break;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Неверно введены данные игрушки, повторите попытку ввода:");
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверно введен вес игрушки, вес должен быть 0<вес<100, повторите попытку ввода:");
                }
            } while (true);
        }
        return infoToys;
    }
}