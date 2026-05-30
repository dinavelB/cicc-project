package services;
import dao.AccountDao;
import connections.DbConnection;
import model.AccountModel;
import util.JBcrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account implements AccountDao{

    public AccountModel loginAccount(int accountNum, String pin) throws Exception {
        JBcrypt bcrypt = new JBcrypt();
        AccountModel account =   new AccountModel();
        Connection connection = DbConnection.StartConnection();
        String foundAccount = "SELECT * FROM accounts WHERE account_number = ?";

//    create a pStatement with the connection method from dbConnection
        PreparedStatement p = connection.prepareStatement(foundAccount);
//        always setInt since each param or ? is counted default 1 onwards
        p.setInt(1, accountNum);
//        results of the query using the prepared statement
        ResultSet resultSet = p.executeQuery();

        if(resultSet.next()){
           account.setFName(resultSet.getString("full_name"));
           account.setAccountNumber(resultSet.getString("account_number"));
           account.setPin(resultSet.getString("pin"));
           account.setBalance(resultSet.getInt("balance"));
           account.setDailyDeposit(resultSet.getInt("daily_deposit"));
           account.setIsActive(resultSet.getBoolean("is_active"));
           account.setDailyWithdrawn(resultSet.getInt("daily_withdrawn"));
        }

        String hashedpassword = bcrypt.hashPassword(pin);
        boolean isSamePass = bcrypt.comparePassword(hashedpassword, account.pin);

        if(!isSamePass){
            throw new Exception("Incorrect Password");
        }

        return account;
    }

}
