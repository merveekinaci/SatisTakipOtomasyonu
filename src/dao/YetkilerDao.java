package dao;

import contract.Yetkiler;
import core.ObjectHelper;
import interfaces.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class YetkilerDao extends ObjectHelper implements DAOInterface<Yetkiler> {

    @Override
    public void Insert(Yetkiler entity) {

        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Yetkiler (Adi) VALUES ('"+entity.getAdi()+"')");
            statement.close();
            connection.close();
        } catch (SQLException e) {

        }

    }

    @Override
    public List<Yetkiler> GetAll() {
        List<Yetkiler> datacontract = new ArrayList<Yetkiler>();
        Connection connection = getConnection();
        Yetkiler contract;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Yetkiler");

            while(resultSet.next()) {
                contract = new Yetkiler();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datacontract;
    }

    @Override
    public Yetkiler Delete(Yetkiler entity) {

        return null;
    }

    @Override
    public void Upate(Yetkiler entity) {

    }

    @Override
    public List<Yetkiler> GetById(int id) {

        return null;
    }

}