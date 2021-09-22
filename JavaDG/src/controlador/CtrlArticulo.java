
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Articulos;
import modelo.ConsultasArticulos;
import vista.MenuPpal;


public class CtrlArticulo implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private Articulos mod;
    private ConsultasArticulos modC;
    private MenuPpal vistaA;
    
    
    public CtrlArticulo(Articulos mod, ConsultasArticulos modC, MenuPpal vistaA){
        
        this.mod = mod;
        this.modC = modC;
        this.vistaA = vistaA;
        this.vistaA.btnIngregarArticulo.addActionListener(this);
    
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngregarArticulo){
            //mod.setIdarticulo(Integer.parseInt(vistaA.txtIdart.getText()));
            mod.setId_categoria_articulo(Integer.parseInt(vistaA.txtCategoriaArt.getText()));
            mod.setArt_descripcion(vistaA.txtNombreArticulo.getText());
            mod.setArt_stock(Integer.parseInt(vistaA.txtStockArticulo.getText()));
            mod.setArt_fecha_vencimiento(vistaA.txtFechaArticulo.getText());
            
            try {
                if(modC.registrar(mod)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
