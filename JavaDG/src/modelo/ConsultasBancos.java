
package modelo;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasBancos extends Conexion{
    
    public boolean registrar(Bancos ban) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO banco (ban_nombre,codigo_banco,ban_estado) VALUES(?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ban.getBan_nombre());
            ps.setString(2, ban.getCodigo_banco());
            ps.setInt(3, ban.getBan_estado());
            ps.execute();
            return true;
        
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
            
        }
    
    }
    public boolean modificar(Bancos ban) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE banco SET ban_nombre=?, codigo_banco=?, ban_estado=? WHERE (idbanco=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ban.getBan_nombre());
            ps.setString(2, ban.getCodigo_banco());
            ps.setInt(3, ban.getBan_estado());
            ps.setInt(4,ban.getIdbanco());
            ps.execute();
            return true;
        
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    
    
    }
    //* Buscar Banco ***
    public boolean buscarBanco(Bancos ban) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM rrss WHERE idrrss=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ban.getIdbanco());
            rs = ps.executeQuery();
            
            if(rs.next()){
                ban.setIdbanco(Integer.parseInt(rs.getString("idbanco")));
                ban.setBan_nombre(rs.getString("ban_nombre"));
                ban.setCodigo_banco(rs.getString("codigo_banco"));
                ban.setBan_estado(Integer.parseInt(rs.getString("ban_estado")));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
   
    }
    
}