package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Comunas;
import modelo.ConsultasComunas;
import vista.MenuPpal;


public class CtrlComunas implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private Comunas mod6;
    private ConsultasComunas modC6;
    private MenuPpal vistaA6;
    
    
    public CtrlComunas(Comunas mod6, ConsultasComunas modC6, MenuPpal vistaA6){
        
        this.mod6 = mod6;
        this.modC6 = modC6;
        this.vistaA6 = vistaA6;
        this.vistaA6.btnIngresarComuna.addActionListener(this);
    
    }
    
    
    public void iniciar(){
        vistaA6.setTitle("Menu Principal");
        vistaA6.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA6.btnIngresarComuna){
            //mod.setIdarticulo(Integer.parseInt(vistaA.txtIdart.getText()));
            //mod6.setId_categoria_articulo(Integer.parseInt(vistaA6.txtCategoriaArt.getText()));
            mod6.setCodigo_comunas(vistaA6.txtCodigoComuna.getText());
            mod6.setNombre_comunas(vistaA6.txtNombreComuna.getText());
            mod6.setCom_estado(Integer.parseInt (vistaA6.txtEstadoComuna.getText()));
            
            try {
                if(modC6.registrar(mod6)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
