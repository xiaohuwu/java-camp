package com.mmall.concurrency.heima;

import java.util.Random;

public class ExerciseTransfer {

    static Random random = new Random();

    public static int randomAmount() {
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);
        Account account1 = new Account(1000);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.transfer(account1, randomAmount());
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account1.transfer(account, randomAmount());
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("all = " + account.getBalance() + account1.getBalance());
    }


}

class Account {
    private int balance;


    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public  void transfer(Account target, int amount) {
        synchronized(this){
            if (this.balance > amount) {
                this.setBalance(this.getBalance() - amount);
                target.setBalance(target.getBalance() + amount);
            }
        }

    }

}
