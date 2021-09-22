
package javadg;

import controlador.CtrlArticulo;
import modelo.Articulos;
import modelo.ConsultasArticulos;
import vista.MenuPpal;

public class JavaDG {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Articulos mod = new Articulos();
        ConsultasArticulos modC = new ConsultasArticulos();
        MenuPpal vistaA = new MenuPpal();
        
        CtrlArticulo ctrl = new CtrlArticulo(mod, modC, vistaA);
        ctrl.iniciar();
        vistaA.setVisible(true);
    }
    
}
