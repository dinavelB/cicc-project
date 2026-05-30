package services;
import dao.AccountDao;
import connections.DbConnection;
import model.AccountModel;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account implements AccountDao{

    public AccountModel loginAccount(int accountNum, int pin) throws Exception {
        Connection connection = DbConnection.StartConnection();
        String foundAccount = "SELECT * FROM accounts WHERE accountNum = ?";

//    create a pStatement with the connection method from dbConnection
        PreparedStatement p = connection.prepareStatement(foundAccount);
//        always setInt since each param or ? is counted default 1 onwards
        p.setInt(1, accountNum);
//        results of the query using the prepared statement
        ResultSet resultSet = p.executeQuery();

        BCrypt hash = new BCrypt();

        AccountModel account =   new AccountModel();

        if(resultSet.next()){
           account.setFName(resultSet.getString("pin"));
           account.setAccountNumber(resultSet.getInt("pin"));
           account.setBalance(resultSet.getInt("balance"));
           account.setDailyDeposit(resultSet.getInt("dailyDeposit"));
           account.setIsActive(resultSet.getBoolean("isActive"));
           account.setDailyWithdrawn(resultSet.getInt("dailyWithdrawn"));
        }


        return account;
    }

}
