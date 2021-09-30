
package modelo;

public class Bancos {
    private int idbanco;
    private String ban_nombre;
    private String codigo_banco;
    private int ban_estado;

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }

    public String getBan_nombre() {
        return ban_nombre;
    }

    public void setBan_nombre(String ban_nombre) {
        this.ban_nombre = ban_nombre;
    }

    public String getCodigo_banco() {
        return codigo_banco;
    }

    public void setCodigo_banco(String codigo_banco) {
        this.codigo_banco = codigo_banco;
    }

    public int getBan_estado() {
        return ban_estado;
    }

    public void setBan_estado(int ban_estado) {
        this.ban_estado = ban_estado;
    }

}