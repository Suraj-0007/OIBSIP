import java.util.Scanner;

class BankAccount {
    private String name;
    private String username;
    private String password;
    private String accountNo;
    private float balance = 100000f;
    private int transactions = 0;
    private String transactionHistory = "";

    public String getName() {
        return name;
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Your Username: ");
        this.username = sc.nextLine();
        System.out.print("Enter Your Password: ");
        this.password = sc.nextLine();
        System.out.print("Enter Your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed. Kindly login.");
    }

    public boolean login() {
        boolean isLoggedIn = false;
        Scanner sc = new Scanner(System.in);

        while (!isLoggedIn) {
            System.out.print("\nEnter Your Username: ");
            String enteredUsername = sc.nextLine();

            if (enteredUsername.equals(username)) {
                while (!isLoggedIn) {
                    System.out.print("Enter Your Password: ");
                    String enteredPassword = sc.nextLine();

                    if (enteredPassword.equals(password)) {
                        System.out.println("\nLogin successful!");
                        isLoggedIn = true;
                    } else {
                        System.out.println("Incorrect Password");
                    }
                }
            } else {
                System.out.println("Username not found");
            }
        }
        return isLoggedIn;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\nWithdrawal successful.");
            String str = amount + " Rs Withdrawn\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    public void deposit() {
        System.out.print("\nEnter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount <= 100000f) {
            transactions++;
            balance += amount;
            System.out.println("\nDeposit successful.");
            String str = amount + " Rs deposited\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nSorry, the deposit limit is 100,000.00 Rs");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        float amount = sc.nextFloat();

        if (balance >= amount) {
            if (amount <= 50000f) {
                transactions++;
                balance -= amount;
                System.out.println("\nSuccessfully transferred to " + recipient);
                String str = amount + " Rs transferred to " + recipient + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry, the transfer limit is 50,000.00 Rs");
            }
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("\nBalance: " + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nTransaction History: Empty");
        } else {
            System.out.println("\nTransaction History:\n" + transactionHistory);
        }
    }
}

class AtmInterface {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (input > limit || input < 1) {
                    System.out.println("Please choose a number between 1 and " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
        System.out.println("1. Register\n2. Exit");
        System.out.print("Enter Your Choice: ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.register();

            while (true) {
                System.out.println("\n1. Login\n2. Exit");
                System.out.print("Enter Your Choice: ");
                int ch = takeIntegerInput(2);

                if (ch == 1) {
                    if (bankAccount.login()) {
                        System.out.println("\n\n**********WELCOME BACK, " + bankAccount.getName() + "**********\n");
                        boolean isFinished = false;

                        while (!isFinished) {
                            System.out.println("1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. Transaction History\n6. Exit");
                            System.out.print("Enter Your Choice: ");
                            int c = takeIntegerInput(6);

                            switch (c) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;
                                case 2:
                                    bankAccount.deposit();
                                    break;
                                case 3:
                                    bankAccount.transfer();
                                    break;
                                case 4:
                                    bankAccount.checkBalance();
                                    break;
                                case 5:
                                    bankAccount.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
