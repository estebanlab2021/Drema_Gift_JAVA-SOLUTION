
package modelo;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasComunas extends Conexion{
    
    public boolean registrar(Comunas com) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO comunas (codigo_comunas, nombre_comunas, com_estado) VALUES(?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            //ps.setInt(1, art.getIdarticulo());
            ps.setString(1, com.getCodigo_comunas());
            ps.setString(2, com.getNombre_comunas());
            ps.setInt(3, com.getCom_estado());
           // ps.setString(4, art.getArt_fecha_vencimiento());
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
    
    public boolean modificar(Comunas com) throws SQLException{
    
    PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE comunas SET codigo_comunas=?, nombre_comunas=?, com_estado=? WHERE (idcomunas=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getCodigo_comunas());
            ps.setString(2, com.getNombre_comunas());
            ps.setInt(3, com.getCom_estado());
            ps.setInt(4, com.getIdcomunas());
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
    //* Buscar Comuna ***

    public boolean buscarComun(Comunas comu) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM comunas WHERE idcomunas=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, comu.getIdcomunas());
            rs = ps.executeQuery();
            
            if(rs.next()){
                comu.setIdcomunas(Integer.parseInt(rs.getString("idcomunas")));
                comu.setCodigo_comunas(rs.getString("codigo_comunas"));
                comu.setNombre_comunas(rs.getString("nombre_comunas"));
                comu.setCom_estado(Integer.parseInt(rs.getString("com_estado")));
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
