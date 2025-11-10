package modelo;

import java.util.Date;

public class Compra {

    private Usuario usuario;
    private Proveedor proveedor;

    private int compraId;
    private String compraCodigo;
    private String compraNumComp;
    private Date compraFecha;
    private double compraTotal;
    private boolean compraEstado;

    public Compra(int compraId, String compraCodigo,String compraNumComp, Date compraFecha, double compraTotal, boolean compraEstado, Usuario usuario, Proveedor proveedor){
        this.compraId = compraId;
        this.compraCodigo = compraCodigo;
        this.compraNumComp = compraNumComp;
        this.compraFecha = compraFecha;
        this.compraTotal = compraTotal;
        this.compraEstado = compraEstado;
        this.usuario = usuario;
        this.proveedor = proveedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public String getCompraCodigo() {
        return compraCodigo;
    }

    public void setCompraCodigo(String compraCodigo) {
        this.compraCodigo = compraCodigo;
    }

    public String getCompraNumComp() {
        return compraNumComp;
    }

    public void setCompraNumComp(String compraNumComp) {
        this.compraNumComp = compraNumComp;
    }

    public Date getCompraFecha() {
        return compraFecha;
    }

    public void setCompraFecha(Date compraFecha) {
        this.compraFecha = compraFecha;
    }

    public double getCompraTotal() {
        return compraTotal;
    }

    public void setCompraTotal(double compraTotal) {
        this.compraTotal = compraTotal;
    }

    public boolean isCompraEstado() {
        return compraEstado;
    }

    public void setCompraEstado(boolean compraEstado) {
        this.compraEstado = compraEstado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                " usuario=" + usuario.getUsuCodigo() +
                ", proveedor=" + proveedor.getProvCodigo() +
                ", compraId=" + compraId +
                ", compraCodigo='" + compraCodigo + '\'' +
                ", compraNumComp='" + compraNumComp + '\'' +
                ", compraFecha=" + compraFecha +
                ", compraTotal=" + compraTotal +
                ", compraEstado=" + compraEstado +
                '}';
    }
}
