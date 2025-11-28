package modelo;

import java.time.LocalDateTime;

public class Venta{

    private Usuario usuario;
    private Cliente cliente;

    private int ventId;
    private String ventCodigo;
    private String ventNumCompro;
    private LocalDateTime ventFecha;
    private double ventTotal;
    private boolean ventEstado;

    public Venta (int ventId, String ventCodigo, String ventNumCompro, LocalDateTime ventFecha, double ventTotal, boolean ventEstado, Usuario usuario , Cliente cliente){
        this.ventId = ventId;
        this.ventCodigo = ventCodigo;
        this.ventNumCompro = ventNumCompro;
        this.ventFecha = ventFecha;
        this.ventTotal = ventTotal;
        this.ventEstado = ventEstado;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public Venta (){

    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getVentId() {
        return ventId;
    }

    public void setVentId(int ventId) {
        this.ventId = ventId;
    }

    public String getVentCodigo() {
        return ventCodigo;
    }

    public void setVentCodigo(String ventCodigo) {
        this.ventCodigo = ventCodigo;
    }

    public String getVentNumCompro() {
        return ventNumCompro;
    }

    public void setVentNumCompro(String ventNumCompro) {
        this.ventNumCompro = ventNumCompro;
    }

    public LocalDateTime getVentFecha() {
        return ventFecha;
    }

    public void setVentFecha(LocalDateTime ventFecha) {
        this.ventFecha = ventFecha;
    }

    public double getVentTotal() {
        return ventTotal;
    }

    public void setVentTotal(double ventTotal) {
        this.ventTotal = ventTotal;
    }

    public boolean isVentEstado() {
        return ventEstado;
    }

    public void setVentEstado(boolean ventEstado) {
        this.ventEstado = ventEstado;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "  ventId=" + ventId +
                ", ventCodigo='" + ventCodigo + '\'' +
                ", ventNumCompro='" + ventNumCompro + '\'' +
                ", ventFecha=" + ventFecha +
                ", ventTotal=" + ventTotal +
                ", ventEstado=" + ventEstado +
                ", empleado= " + usuario.getUsuId() +
                ", cliente= " + cliente.getCliId() +
                '}';
    }
}
