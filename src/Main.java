import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Buyer[] buyers = new Buyer[7];
        for (int i = 0; i < 7; i++) {
            boolean check = true;
            while (check){
                try{
                    System.out.println("Створення покупця №"+i);
                    System.out.println("Введіть ім'я");
                    String firstName = console.nextLine();
                    System.out.println("Введіть прізвище");
                    String lastName = console.nextLine();
                    System.out.println("Введіть по батькові");
                    String patronymic = console.nextLine();
                    System.out.println("Введіть номерт карти");
                    String cardNumber = console.nextLine();
                    System.out.println("Введіть рахунку");
                    String accountNumber = console.nextLine();
                    buyers[i] = new Buyer(firstName, lastName, patronymic, cardNumber, accountNumber);
                    System.out.println("Успішно!");
                    check = false;
                } catch (InvalidNameException ex){
                    System.out.println(ex.getMessage());
                } catch (InvalidCardNumberException ex2){
                    System.out.println(ex2.getMessage());
                } catch (InvalidAccountNumberException ex3){
                    System.out.println(ex3.getMessage());
                }
            }
        }
        print(buyers);
        System.out.println("Відсортовано в алфавітному порядку за прізвищем: ");
        print(getListAzOrder(buyers).toArray(Buyer[]::new));
        System.out.println("Введіть 1 значення діапазону номера картки: ");
        Boolean check = true;
        String oneRange = console.nextLine();
        while (check){
            if (!oneRange.matches("^\\d{16}$")){
                continue;
            }
            check = false;
        }
        System.out.println("Введіть 2 значення діапазону номера картки: ");
        Boolean check2 = true;
        String twoRange = console.nextLine();
        while (check2){
            if (!twoRange.matches("^\\d{16}$")){
                continue;
            }
            check2 = false;
        }
        print(getCaraNumberRange(oneRange, twoRange, buyers).toArray(Buyer[]::new));
    }
    public static ArrayList<Buyer> getListAzOrder(Buyer[] buyers){
        Buyer[] sorted = buyers;
        Arrays.sort(sorted, Comparator.comparing(Buyer::getLastName));
        return new ArrayList<>(Arrays.asList(sorted));
    }
    public static ArrayList<Buyer> getCaraNumberRange(String oneRange, String twoRange, Buyer[] buyers){
        long oneRangeLong = Long.parseLong(oneRange);
        long twoRangeLong = Long.parseLong(twoRange);
        ArrayList<Buyer> sorted = new ArrayList<>();
        for (Buyer buyer : buyers) {
            long cardNumber = Long.parseLong(buyer.getCardNumber());
            if (cardNumber >= oneRangeLong && cardNumber <= twoRangeLong) {
                sorted.add(buyer);
            }
        }
        return sorted;
    }
    public static void print(Buyer[] buyers){
        for (Buyer buyer : buyers) {
            System.out.println(buyer.toString());
        }
    }
}