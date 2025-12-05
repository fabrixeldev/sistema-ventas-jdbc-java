package modelo;

import java.time.LocalDate;

public class Lote {

    private Producto producto;

    private int loteId;
    private String loteCodigo;
    private int loteCantidad;
    private LocalDate loteFechaCreacion;
    private LocalDate loteFechaVenc;

    public Lote(int loteId, String loteCodigo, int loteCantidad, LocalDate loteFechaCreacion, LocalDate loteFechaVenc, Producto producto){
        this.loteId = loteId;
        this.loteCodigo = loteCodigo;
        this.loteCantidad = loteCantidad;
        this.loteFechaCreacion = loteFechaCreacion;
        this.loteFechaVenc = loteFechaVenc;
        this.producto = producto;
    }

    public Lote(){

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public String getLoteCodigo() {
        return loteCodigo;
    }

    public void setLoteCodigo(String loteCodigo) {
        this.loteCodigo = loteCodigo;
    }

    public int getLoteCantidad() {
        return loteCantidad;
    }

    public void setLoteCantidad(int loteCantidad) {
        this.loteCantidad = loteCantidad;
    }

    public LocalDate getLoteFechaCreacion() {
        return loteFechaCreacion;
    }

    public void setLoteFechaCreacion(LocalDate loteFechaCreacion) {
        this.loteFechaCreacion = loteFechaCreacion;
    }

    public LocalDate getLoteFechaVenc() {
        return loteFechaVenc;
    }

    public void setLoteFechaVenc(LocalDate loteFechaVenc) {
        this.loteFechaVenc = loteFechaVenc;
    }

    @Override
    public String toString() {
        return "Lote{" +
                ", loteId=" + loteId +
                ", loteCodigo='" + loteCodigo + '\'' +
                ", loteCantidad=" + loteCantidad +
                ", loteFechaCreacion=" + loteFechaCreacion +
                ", loteFechaVenc=" + loteFechaVenc +
                ", producto=" + producto.getProdId() +
                '}';
    }
}
