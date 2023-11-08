import java.util.Scanner;

interface Atm {
    String bankName = "Bank of Baroda";

    double checkBalance();

    double deposit(double amount);

    double withdraw(double withdrawAmount);

    boolean checkForSufficientAmount(double amount);


}

class ATMMachine implements Atm {
    private double balanceAmount;
    private static final double MINIMUM_BALANCE = 1000;
    private static final double PENALTY_RATE = 0.02;

    public double checkBalance() {
        return balanceAmount;
    }

    public double deposit(double depositAmount) {
        balanceAmount += depositAmount;
        return balanceAmount;
    }

    public double withdraw(double withdrawAmount) {
        if (checkForSufficientAmount(withdrawAmount + MINIMUM_BALANCE)) {
            balanceAmount -= withdrawAmount;
            return balanceAmount;
        } else {
            return 0;
        }
    }

    public double penalizeAction(double amt) {
        if (amt > balanceAmount) {
            System.out.println("Insufficient Balance. Please try again with a different amount.");
        } else {

            balanceAmount -= amt;
            double penalty = PENALTY_RATE * balanceAmount;
            balanceAmount -= penalty;
        }
        return balanceAmount;
    }

    public boolean checkForSufficientAmount(double amount) {
        return balanceAmount >= amount;
    }

    public void bankName()
    {
        System.out.println(Atm.bankName);
    }




}

class BankAccount {
    private String name;
    private String address;
    private int accno = 199450001;
    private ATMMachine atmMachine = new ATMMachine();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccno() {
        return accno;
    }

    public double checkBalance() {
        return atmMachine.checkBalance();
    }

    public double deposit(double depositAmount) {
        return atmMachine.deposit(depositAmount);
    }

    public double withdraw(double withdrawAmount) {
        return atmMachine.withdraw(withdrawAmount);
    }

    public double penalizeAction(double amt) {
        return atmMachine.penalizeAction(amt);
    }

    public boolean checkForSufficientAmount(double amount) {
        return atmMachine.checkForSufficientAmount(amount);
    }

    public void printAccountDetails(){

        System.out.print("Name of the Bank :");
        atmMachine.bankName();
        setName("Account HolderName:Himanshu Vaishya");
        System.out.println(getName());
        System.out.print("Bank Account Number: ");

        System.out.println(getAccno());
        setAddress("ABC Colony");
        System.out.println("Address:"+getAddress());




    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount ba = new BankAccount();
        boolean isRunning = true;

        while (isRunning) {
            boolean flag = true;
            System.out.println("Enter 1 for deposit money in your account");
            System.out.println("Enter 2 for checking account balance");
            System.out.println("Enter 3 for withdrawing money");
            System.out.println("Enter 4 for printing Account Details");

            System.out.println("Enter 5 for exit");
            double amountAfterPenalty = 0;
            int choice = sc.nextInt();
            double in;
            double output;

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to be deposited");
                    in = sc.nextDouble();
                    output = ba.deposit(in);
                    System.out.println("Amount deposited successfully, balance amount = " + output);
                    break;
                case 2:
                    System.out.println(ba.checkBalance());
                    break;
                case 3:
                    System.out.println("Enter amount to be withdrawn");
                    in = sc.nextDouble();
                    output = ba.withdraw(in);

                    if (output == 0) {
                        System.out.println("Insufficient amount in your account");
                        System.out.println("You will be penalized if you keep the balance less than 1000");
                        if (flag) {
                            System.out.println("Are you sure to withdraw all the amount? Think again; you will be penalized. Enter 'yes' or 'no':");
                            sc.nextLine();
                            String input = sc.nextLine();
                            if (input.equals("yes")) {
                                flag = false;
                                System.out.println("Enter the amount to be withdrawn:");
                                in = sc.nextDouble();
                                if (ba.checkForSufficientAmount(in)) {
                                    amountAfterPenalty = ba.penalizeAction(in);
                                    System.out.println("Amount withdrawn successfully, and the balance amount is " + amountAfterPenalty);
                                } else {
                                    System.out.println("Insufficient balance");
                                }
                            }
                        }
                    } else {
                        System.out.println("Amount withdrawn successfully, and the balance amount is " + output);
                    }
                    break;


                case 4:
                    ba.printAccountDetails();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
