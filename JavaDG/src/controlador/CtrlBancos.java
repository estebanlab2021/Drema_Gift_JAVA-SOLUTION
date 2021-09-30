
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Bancos;
import modelo.ConsultasBancos;
import vista.MenuPpal;


public class CtrlBancos implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private final Bancos mod8;
    private final ConsultasBancos modC8;
    private final MenuPpal vistaA8;
    
    
public CtrlBancos(Bancos mod8, ConsultasBancos modC8, MenuPpal vistaA8){
        
        this.mod8 = mod8;
        this.modC8 = modC8;
        this.vistaA8 = vistaA8;
        this.vistaA8.btnIngresarBanco.addActionListener(this);
        this.vistaA8.btnModificarBanco.addActionListener(this);
        this.vistaA8.btnLimpiarBanco.addActionListener(this);
        this.vistaA8.btnBuscarBanco.addActionListener(this);
        this.vistaA8.rbtnInactvarBanco.addActionListener(this);
        this.vistaA8.rbtnActivarBanco.addActionListener(this);
        //*String estadobtn = null;
    }
    
    
public void iniciar(){
        vistaA8.setTitle("Menu Principal");
        vistaA8.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA8.btnIngresarBanco){
              mod8.setBan_nombre(vistaA8.txtNombreBanco.getText());
              mod8.setCodigo_banco(vistaA8.txtCodigoBanco.getText());
              mod8.setBan_estado(Integer.parseInt (vistaA8.guardarRadioButtonBanco()));
              
              try {
                   if(modC8.registrar(mod8)){
                      JOptionPane.showMessageDialog(null, "Registro Guardado");
                   }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlBancos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        
       
        if(e.getSource() == vistaA8.btnModificarBanco){
            mod8.setIdbanco(Integer.parseInt(vistaA8.txtIdBanco.getText()));
            mod8.setBan_nombre(vistaA8.txtNombreBanco.getText());
            mod8.setCodigo_banco(vistaA8.txtCodigoBanco.getText());
            mod8.setBan_estado(Integer.parseInt (vistaA8.guardarRadioButtonBanco()));
            
            try {
                if(modC8.modificar(mod8)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    //System.out.println(modC1.modificar());
                    //limpiarBanco();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiarBanco();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlBancos.class.getName()).log(Level.SEVERE, null, ex);
            }
    
       }
            
        if(e.getSource() == vistaA8.btnBuscarBanco){
            mod8.setIdbanco(Integer.parseInt(vistaA8.txtBuscarBanco.getText()));
            
            try {
                if(modC8.buscarBanco(mod8)){
                    vistaA8.txtNombreBanco.setText(mod8.getBan_nombre());

                }else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro");
                    limpiarBanco();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlBancos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == vistaA8.btnLimpiarBanco){
            limpiarBanco();
        }
        
    }
    
    
    public void limpiarBanco(){
        vistaA8.txtNombreBanco.setText(null);
        vistaA8.txtCodigoBanco.setText(null);
        vistaA8.btnGroupBancos.clearSelection();
        vistaA8.txtBuscarBanco.setText(null);
        vistaA8.txtCodigoBanco.setText(null);
    }
    
}
