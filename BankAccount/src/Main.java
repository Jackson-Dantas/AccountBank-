import model.entities.Account;
import model.exceptions.ExceedLimitException;
import model.exceptions.NoBalanceException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        try {
            Locale.setDefault(Locale.US);
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance,withdrawLimit);

            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            account.withDraw(amount);

        } catch (NoBalanceException noBalanceException) {
            System.out.println(noBalanceException.getMessage());

        } catch (ExceedLimitException exceedLimitException){

            System.out.println(exceedLimitException.getMessage());

        } catch (RuntimeException runtimeException){
            System.out.println("Unexpected error!!");
        }
    }
}