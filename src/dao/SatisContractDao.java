package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import contract.SatisContract;
import core.ObjectHelper;
import dao.contract.SatisContract;
import dao.core.ObjectHelper;
import interfaces.DAOInterface;

public class SatisContractDao extends ObjectHelper implements DAOInterface<SatisContract> {

    @Override
    public void Insert(SatisContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Satis (UrunId,MusteriId,Tarih,Adet,PersonelId)"
                    + " VALUES ("+entity.getUrunId()+","+entity.getMusteriId()+",'"+entity.getTarih()+"',"+entity.getAdet()+","+entity.getPersonelId()+")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<SatisContract> GetAll() {
        return null;
    }

    @Override
    public SatisContract Delete(SatisContract entity) {
        return null;
    }

    @Override
    public void Upate(SatisContract entity) {

    }

    @Override
    public List<SatisContract> GetById(int id) {

        return null;
    }

}