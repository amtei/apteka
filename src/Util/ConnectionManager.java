package Util;

import DaoException.DaoException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionManager {
    private static final String PASSWORD_KEY="database.password";
    private static final String URL_KEY="database.url";
    private static final String USERNAME_KEY="database.username";
    private static final String POOL_SIZE_KEY="database.poolsize";
    private static final Integer DEFAULT_POOL_SIZE=10;

    private static BlockingQueue<Connection> pool;
    private static List<Connection> sourceConnections;



 static {
    loadDriver();
    initConnectionPool();
 }



    private ConnectionManager(){

    }
        private static void initConnectionPool() {
     var poolsize=PropertiesUtil.get(POOL_SIZE_KEY);
     var size=poolsize==null?DEFAULT_POOL_SIZE:Integer.parseInt(poolsize);
     pool=new ArrayBlockingQueue<>(size);
     sourceConnections=new ArrayList<>(size);
            for (int i = 0; i <size ; i++) {
                var connection=open();
                var ProxyConnection =(Connection) Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(), new Class[]{Connection.class},
                        (proxy, method, args) -> method.getName().equals("close") ? pool.add((Connection) proxy) : method.invoke(connection, args));
                pool.add(ProxyConnection);
                sourceConnections.add(connection);

            }



   }
   public static Connection get(){
       try {
           return pool.take();
       } catch (InterruptedException e) {
           throw new DaoException(e);
       }
   }
  private static Connection open() {
       try {
           return DriverManager.getConnection(

                   PropertiesUtil.get(URL_KEY),
                   PropertiesUtil.get( USERNAME_KEY),
                   PropertiesUtil.get(PASSWORD_KEY)
           );
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }



   }  private static void loadDriver () {
    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
 }
    public static void closePool() {
        try {
            for (Connection sourceConnection : sourceConnections) {
                sourceConnection.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
}
}