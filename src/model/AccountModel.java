package model;

public class AccountModel
{
    public String full_name;
    public String account_number;
    public int balance;
    public double daily_withdrawn;
    public double daily_deposit;
    public boolean is_active;
    public String pin;

    public void setFName(String full_name){
        this.full_name = full_name;
    }

    public void setPin(String pin){
        this.pin = pin;
    }

    public void setAccountNumber(String account_number){
        this.account_number = account_number;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setDailyWithdrawn(double daily_withdrawn){
        this.daily_withdrawn = daily_withdrawn;
    }

    public  void setDailyDeposit(double daily_deposit){
        this.daily_deposit = daily_deposit;
    }

    public void setIsActive(boolean is_active){
        this.is_active = is_active;
    }
}
