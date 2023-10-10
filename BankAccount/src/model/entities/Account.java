package model.entities;

import model.exceptions.ExceedLimitException;
import model.exceptions.NoBalanceException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance, withDrawLimit;

    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void withDraw(Double amount) throws ExceedLimitException, NoBalanceException {

        if(amount > this.getWithDrawLimit() ){
            throw new ExceedLimitException("Withdraw error: The amount exceeds withdraw limit");
        }

        if(amount > this.getBalance()){
            throw new NoBalanceException("Withdraw error: Not enough balance ");
        }

        this.balance -= amount;
        System.out.println("New balance: " + this.getBalance());
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }
}
