package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import contract.MusteriContract;
import core.ObjectHelper;
import interfaces.DAOInterface;

public class MusteriDao extends ObjectHelper implements DAOInterface<MusteriContract> {

    @Override
    public void Insert(MusteriContract entity) {

        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(" Musteri (AdiSoyadi,Telefon,Adres,Sehir) VALUES ('"+entity.getAdiSoyadi()+"','"+entity.getTelefon()+"','"+entity.getAdres()+"','"+entity.getSehir()+"') ");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MusteriContract> GetAll() {

        return null;
    }

    @Override
    public MusteriContract Delete(MusteriContract entity) {

        return null;
    }

    @Override
    public void Upate(MusteriContract entity) {

    }

    @Override
    public List<MusteriContract> GetById(int id) {

        return null;
    }

}
