package DAO;

import DaoException.DaoException;
import Util.ConnectionManager;
import entity.Basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketDao {

    public static final BasketDao Instance=new BasketDao();

    public BasketDao() {
    }

public static final String SAVE_SQL= """
        INSERT INTO basket (basket_id,med_name,price)
        VALUES( ?,?,?)
        """;

public Basket save (Basket basket) {

    try {
        var connection = ConnectionManager.get();
        var statement = connection.prepareStatement(SAVE_SQL);
        statement.setLong(1, basket.getBasket_id());
        statement.setString(2, basket.getMed_name());
        statement.setInt(3, basket.getPrice());
    statement.executeUpdate();

    } catch (SQLException e) {
        throw new DaoException(e);
    }
return basket;

}
public static BasketDao getInstance(){
    return Instance;
}


}
