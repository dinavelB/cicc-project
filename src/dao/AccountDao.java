package dao;
import model.AccountModel;

public interface AccountDao {
    public AccountModel loginAccount(int accountNum, String pin) throws Exception;
}
