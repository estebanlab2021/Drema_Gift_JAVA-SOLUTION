
package javadg;

import controlador.CtrlArticulo;
import modelo.Articulos;
import modelo.ConsultasArticulos;
import vista.MenuPpal;
import controlador.CtrlComunas;
import modelo.Comunas;
import modelo.ConsultasComunas;

public class JavaDG {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Articulos mod = new Articulos();
        ConsultasArticulos modC = new ConsultasArticulos();
        
        Comunas mod6 = new Comunas();
        ConsultasComunas modC6 = new ConsultasComunas();
        
        MenuPpal vistaA = new MenuPpal();
        
        CtrlArticulo ctrl = new CtrlArticulo(mod, modC, vistaA);
        ctrl.iniciar();
        
        CtrlComunas ctrl6 = new CtrlComunas(mod6, modC6, vistaA);
        ctrl6.iniciar();
        
        vistaA.setVisible(true);
                      
    }
    
}
