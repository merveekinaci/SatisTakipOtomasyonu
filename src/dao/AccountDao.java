package dao;

import contract.AccountsContract;
import core.ObjectHelper;
import interfaces.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDao extends ObjectHelper implements DAOInterface<AccountsContract> {

    @Override
    public void Insert(AccountsContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Account (YetkiId,PersonelId,Sifre) VALUES (" + entity.getYettkiId()
                    + "," + entity.getPersonelId() + "," + entity.getSifre() + ")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public AccountsContract GetPersonelIdveSifre(int personelId, String sifre) {

        AccountsContract contract = new AccountsContract();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM account WHERE PersonelId = " + personelId + " AND Sifre = '" + sifre.trim() + "'");

            while (resultSet.next()) {
                contract.setId(resultSet.getInt("Id"));
                contract.setPersonelId(resultSet.getInt("PersonelId"));
                contract.setSifre(resultSet.getString("Sifre"));
                contract.setYettkiId(resultSet.getInt("YetkiId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contract;
    }

    public AccountsContract GetYetkiId(int personelId) {

        AccountsContract contract = new AccountsContract();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM account WHERE PersonelId = " + personelId + " " );

            while (resultSet.next()) {
                contract.setId(resultSet.getInt("Id"));
                contract.setPersonelId(resultSet.getInt("PersonelId"));
                contract.setYettkiId(resultSet.getInt("YetkiId"));
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contract;
    }

    @Override
    public List<AccountsContract> GetAll() {
        return null;
    }

    @Override
    public AccountsContract Delete(AccountsContract entity) {

        return null;
    }

    @Override
    public void Upate(AccountsContract entity) {

    }

    @Override
    public List<AccountsContract> GetById(int id) {

        return null;
    }

}