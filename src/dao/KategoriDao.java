package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contract.KategoriContract;
import core.ObjectHelper;
import interfaces.DAOInterface;

public class KategoriDao extends ObjectHelper implements DAOInterface<KategoriContract> {

    @Override
    public void Insert(KategoriContract entity) {

        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Kategori (Adi, ParentId) VALUES ('" + entity.getAdi() + "'," + entity.getParentId() + ")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<KategoriContract> GetAll() {

        List<KategoriContract> dataContracts = new ArrayList<KategoriContract>();
        Connection connection = getConnection();
        KategoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori");
            while (resultSet.next()) {
                contract = new KategoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));
                dataContracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataContracts;
    }

    public List<KategoriContract> GetAllParentId() {

        List<KategoriContract> dataContracts = new ArrayList<KategoriContract>();
        Connection connection = getConnection();
        KategoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0");
            while (resultSet.next()) {
                contract = new KategoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));
                dataContracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataContracts;
    }

    @Override
    public KategoriContract Delete(KategoriContract entity) {

        return null;
    }

    @Override
    public void Upate(KategoriContract entity) {

    }

    @Override
    public List<KategoriContract> GetById(int id) {

        return null;
    }
}