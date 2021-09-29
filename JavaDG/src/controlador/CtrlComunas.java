package controlador;

//*** @author Jessica *********
 
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
    private Comunas mod1;
    private ConsultasComunas modC1;
    private MenuPpal vistaA;
    
    
    public CtrlComunas(Comunas mod1, ConsultasComunas modC1, MenuPpal vistaA){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA = vistaA;
        this.vistaA.btnIngresarComuna.addActionListener(this);
        this.vistaA.btnModComuna.addActionListener(this);
        this.vistaA.btnLimpiarComuna.addActionListener(this);
        this.vistaA.btnBuscarComuna.addActionListener(this);
        this.vistaA.rbtnInactivoComuna.addActionListener(this);
        this.vistaA.rbtnActivoComuna .addActionListener(this);
        String estadobtn = null;
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngresarComuna){
            mod1.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod1.setNombre_comunas(vistaA.txtNombreComuna.getText());
            mod1.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
            try {
                if(modC1.registrar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaA.btnModComuna){
            mod1.setIdcomunas(Integer.parseInt(vistaA.txtIdComunas.getText()));
            mod1.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod1.setNombre_comunas(vistaA.txtNombreComuna.getText());
            mod1.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
            try {
                if(modC1.modificar(mod1)){
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
            mod1.setIdcomunas(Integer.parseInt(vistaA.txtBusqudaRS.getText()));
            
            try {
                if(modC1.buscarComun(mod1)){
                    vistaA.txtNombreComuna.setText(mod1.getNombre_comunas());

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
