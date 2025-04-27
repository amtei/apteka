package DAO;

import DaoException.DaoException;
import Util.ConnectionManager;
import entity.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MedicineDao {
public static final MedicineDao INSTANCE= new MedicineDao();


    public MedicineDao() {
    }

    public static final String ANALOG_SQL= """
            SELECT med_name,id,primaryelement
            from medicine 
            where primaryelement=(
            select primaryelement
            from medicine 
            where med_name= ?
            )
           
            
       
            """;

    public static final String SAVE_SQL= """
            INSERT INTO medicine(primaryelement,med_name,price)
            VALUES (?,?,?)
           
            """;

    public static final String DELETE_SQL= """
            Delete from medicine
            where id =?
            """;
    public static final String FIND_BY_NAME= """
            SELECT med_name,
            id,
            primaryelement,
            price
            from medicine 
            WHERE med_name=?
            
            """;


    public Optional<Medicine> AnalogSql( String name){
        try {
            var connection = ConnectionManager.get();

        var statement = connection.prepareStatement(ANALOG_SQL);
        statement.setString(1,name);
            var query = statement.executeQuery();
            Medicine medicine=null;
            if(query.next()){
      medicine=new Medicine(
                        query.getLong("id"),
                        query.getString("med_name"),
                        query.getString("primaryelement")
                );
            }return Optional.ofNullable(medicine);


        }catch (SQLException throwables){
            throw new DaoException(throwables);
        }


    }

    public Optional<Medicine> findByName(String name){
        try {
            var connection = ConnectionManager.get() ;
            var statement = connection.prepareStatement(FIND_BY_NAME);
            statement.setString(1,name);
            var resultSet = statement.executeQuery();
            Medicine medicine=null;
            if(resultSet.next()){
                medicine=new Medicine(
                        resultSet.getLong("id"),
                        resultSet.getString("primaryelement"),
                        resultSet.getString("med_name"),
                        resultSet.getInt("price")

                );

            }return Optional.ofNullable(medicine);


        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    public boolean delete(Long id){
        try {
            var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(DELETE_SQL);
            statement.setLong(1,id);

        return     statement.executeUpdate()>0;

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    public Medicine save(Medicine medicine){

        try {
            var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(SAVE_SQL);
            statement.setString(1,medicine.getPrimaryelement());
            statement.setString(2, medicine.getMed_name());
            statement.setInt(3,medicine.getPrice());
            statement.executeUpdate();

            var keys = statement.getGeneratedKeys();
            if (keys.next()){
                medicine.setId(keys.getLong("id"));
            }
            return medicine;


        } catch (SQLException e) {
            throw new DaoException(e);
        }


    }
public static MedicineDao getInstance(){
        return INSTANCE;
}

}
