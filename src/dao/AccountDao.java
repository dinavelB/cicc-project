package dao;
import model.AccountModel;

public interface AccountDao {
    public AccountModel loginAccount(int accountNum, int pin) throws Exception;
}
