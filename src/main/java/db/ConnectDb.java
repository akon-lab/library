package db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDb {
    private Connection connection = null;


    public Connection getConnection() {

        if (connection == null) {
            try {
                Context initialContext = new InitialContext();
                Context envCtx = (Context) initialContext.lookup("java:comp/env");
                DataSource ds = (DataSource) envCtx.lookup("jdbc/library");
                connection = ds.getConnection();
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
