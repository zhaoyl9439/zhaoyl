package com.example.demo.study.object;

public class AccountTest {

    public static void main(String[] args) {

        Account account = new Account(1122, 20000, 0.045);

        account.withdraw(30000);
        System.out.println("您的账户余额为：" + account.getBalance());
        account.withdraw(2500);
        System.out.println("您的账户余额为：" + account.getBalance());
        account.deposit(3000);
        System.out.println("您的账户余额为：" + account.getBalance());

        System.out.println("月利率为：" + (account.getMonthInterst() * 100) + "%");



    }
}

class CheckAccountTest{

    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.045, 5000);

        checkAccount.withdraw(5000);
        System.out.println("您的余额为：" + checkAccount.getBalance());
        System.out.println("您的可透支余额为：" + checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("您的余额为：" + checkAccount.getBalance());
        System.out.println("您的可透支余额为：" + checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
    }

}

class Account {

    private int id; //账号
    private double balance; //余额
    private double annualInterestRate; //年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    //返回月利率
    public double getMonthInterst(){
        return annualInterestRate / 12;
    }
    // 取钱
    public void withdraw(double ammount){
        if (balance >= ammount){
            balance -= ammount;
            return;
        }
        System.out.println("余额不足");
    };
    //存钱
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}

class CheckAccount extends Account{

    private double overdraft; //可透支余额

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double ammount) {
        // 余额足够消费
        if (getBalance() >= ammount){
            super.withdraw(ammount);
        } else if (overdraft >= ammount - getBalance()){ //透支余额+足够消费
            overdraft -= (ammount - getBalance());
            //setBalance(0);
            // 或
            super.withdraw(getBalance());
        } else {
            System.out.println("超过可透余额");
        }
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}


