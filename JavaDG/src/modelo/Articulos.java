
package modelo;

public class Articulos {
    private int idarticulo;
    private int id_categoria_articulo;
    private String art_descripcion;
    private int art_stock;
    private String art_fecha_vencimiento;

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public int getId_categoria_articulo() {
        return id_categoria_articulo;
    }

    public void setId_categoria_articulo(int id_categoria_articulo) {
        this.id_categoria_articulo = id_categoria_articulo;
    }

    public String getArt_descripcion() {
        return art_descripcion;
    }

    public void setArt_descripcion(String art_descripcion) {
        this.art_descripcion = art_descripcion;
    }

    public int getArt_stock() {
        return art_stock;
    }

    public void setArt_stock(int art_stock) {
        this.art_stock = art_stock;
    }

    public String getArt_fecha_vencimiento() {
        return art_fecha_vencimiento;
    }

    public void setArt_fecha_vencimiento(String art_fecha_vencimiento) {
        this.art_fecha_vencimiento = art_fecha_vencimiento;
    }

    
    
    
    
    
}
