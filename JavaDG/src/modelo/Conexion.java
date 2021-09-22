
package modelo;

//import com.sun.jdi.connect.spi.Connection;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    
    private final String user = "root";
    private final String password = "1234";
    private final String url = "jdbc:mysql://localhost:3306/bbdd_dream_gift?serverTimezone=UTC";
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        } 
        return con;
    }
    
}
