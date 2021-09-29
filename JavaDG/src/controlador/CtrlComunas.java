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
    private MenuPpal vistaA;
    
    
    public CtrlComunas(Comunas mod6, ConsultasComunas modC6, MenuPpal vistaA){
        
        this.mod6 = mod6;
        this.modC6 = modC6;
        this.vistaA = vistaA;
        this.vistaA.btnIngresarComuna.addActionListener(this);
        this.vistaA.btnModComuna.addActionListener(this);
        this.vistaA.btnLimpiarComuna.addActionListener(this);
        this.vistaA.btnBuscarComuna.addActionListener(this);
        this.vistaA.rbtnInactivoComuna.addActionListener(this);
        this.vistaA.rbtnActivoComuna .addActionListener(this);
                 
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngresarComuna){
            mod6.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod6.setNombre_comunas(vistaA.txtNombreComuna.getText());
            //mod6.setCom_estado(Integer.parseInt (vistaA.txtEstadoComuna.getText()));
            mod6.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
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
        
        if(e.getSource() == vistaA.btnModComuna){
            mod6.setIdcomunas(Integer.parseInt(vistaA.txtIdComunas.getText()));
            mod6.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod6.setNombre_comunas(vistaA.txtNombreComuna.getText());
            mod6.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
            try {
                if(modC6.modificar(mod6)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    //System.out.println(modC1.modificar());
                    //limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA.btnBuscarComuna){
            mod6.setIdcomunas(Integer.parseInt(vistaA.txtBuscarComunas.getText()));
            
            try {
                if(modC6.BuscarCOMUN(mod6)){
                    vistaA.txtNombreComuna.setText(mod6.getNombre_comunas());

                }else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro");
                    limpiar();
                }
            } catch (SQLException ex) {
                
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA.btnLimpiarComuna){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA.txtIdComunas.setText(null);
        vistaA.txtNombreComuna.setText(null);
        vistaA.btnGroupComunas.clearSelection();
        vistaA.txtBuscarComunas.setText(null);
        vistaA.txtCodigoComuna.setText(null);
                
    }
    
}
