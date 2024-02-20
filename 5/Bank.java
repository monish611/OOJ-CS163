class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of Rs." + amount + " successful");
    }

    void displayBalance() {
        System.out.println("Account Balance: Rs." + balance);
    }

    void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful");
        } else {
            System.out.println("Insufficient balance for withdrawal");
        }
    }
}

class CurAcct extends Account {
    double minimumBalance;
    double serviceCharge;

    CurAcct(String name, int accNo, String type, double bal, double minBal, double charge) {
        super(name, accNo, type, bal);
        minimumBalance = minBal;
        serviceCharge = charge;
    }

    void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful");
        } else {
            System.out.println("Insufficient balance for withdrawal. Service charge of Rs." + serviceCharge + " applied.");
            balance -= serviceCharge;
        }
    }

    void checkbook() {
        System.out.println("Checkbook facilities are available and will be sent soon.");
    }
}

class SavAcct extends Account {
    double interestRate;

    SavAcct(String name, int accNo, String type, double bal, double rate) {
        super(name, accNo, type, bal);
        interestRate = rate;
    }

    void computeInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest of Rs." + interest + " added to account");
    }

    void checkbook() {
        System.out.println("Checkbook facilities not available.");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CurAcct currentAccount = new CurAcct("Monish", 123456, "Current", 5000, 1000, 50);
        SavAcct savingsAccount = new SavAcct("Navaneeth", 654321, "Savings", 10000, 5);

        System.out.println("Current Account Details:");
        currentAccount.displayBalance();
        currentAccount.deposit(2000);
        currentAccount.displayBalance();
        currentAccount.withdraw(7000);
        currentAccount.displayBalance();
        currentAccount.withdraw(3000);
        currentAccount.displayBalance();
        currentAccount.checkbook();

        System.out.println("\nSavings Account Details:");
        savingsAccount.displayBalance();
        savingsAccount.deposit(5000);
        savingsAccount.displayBalance();
        savingsAccount.computeInterest();
        savingsAccount.displayBalance();
        savingsAccount.withdraw(15000);
        savingsAccount.displayBalance();
        savingsAccount.checkbook();

        scanner.close();
    }
}
