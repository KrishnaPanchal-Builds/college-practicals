class Bank {
    protected String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public double getInterestRate() {
        return 0.0;
    }

    public void displayInterestRate() {
        System.out.println("Bank: " + bankName + " | Applicable Interest Rate: " + getInterestRate() + "%");
    }

    public double calculateSimpleInterest(double principal, int years) {
        return (principal * getInterestRate() * years) / 100.0;
    }
}

class SBI extends Bank {
    public SBI() {
        super("State Bank of India (SBI)");
    }

    @Override
    public double getInterestRate() {
        return 6.50;
    }
}

class ICICI extends Bank {
    public ICICI() {
        super("ICICI Bank");
    }

    @Override
    public double getInterestRate() {
        return 7.00;
    }
}

class HDFC extends Bank {
    public HDFC() {
        super("HDFC Bank");
    }

    @Override
    public double getInterestRate() {
        return 7.25;
    }
}

class Axis extends Bank {
    public Axis() {
        super("Axis Bank");
    }

    @Override
    public double getInterestRate() {
        return 7.10;
    }
}

class MethodOverridingDemo {
    public static void main(String[] args) {
        System.out.println("--- Banking Interest Rates (Method Overriding & Runtime Polymorphism) ---\n");

        Bank[] banks = {
            new SBI(),
            new ICICI(),
            new HDFC(),
            new Axis()
        };

        double principal = 100000.0;
        int years = 3;

        System.out.printf("Sample Loan/Deposit Calculation for Principal: Rs. %.2f over %d years:%n%n", principal, years);

        for (Bank bank : banks) {
            bank.displayInterestRate();
            double interest = bank.calculateSimpleInterest(principal, years);
            System.out.printf("  -> Interest accrued for %d years: Rs. %.2f%n", years, interest);
            System.out.println("------------------------------------------------------------");
        }
    }
}
