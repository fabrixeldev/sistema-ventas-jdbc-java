package modelo;

import java.util.Date;

public class Lote {

    private Producto producto;

    private int loteId;
    private String loteCodigo;
    private int loteCantidad;
    private Date loteFechaCreacion;
    private Date loteFechaVenc;

    public Lote(int loteId, String loteCodigo, int loteCantidad, Date loteFechaCreacion, Date loteFechaVenc, Producto producto){
        this.loteId = loteId;
        this.loteCodigo = loteCodigo;
        this.loteCantidad = loteCantidad;
        this.loteFechaCreacion = loteFechaCreacion;
        this.loteFechaVenc = loteFechaVenc;
        this.producto = producto;
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

    public Date getLoteFechaCreacion() {
        return loteFechaCreacion;
    }

    public void setLoteFechaCreacion(Date loteFechaCreacion) {
        this.loteFechaCreacion = loteFechaCreacion;
    }

    public Date getLoteFechaVenc() {
        return loteFechaVenc;
    }

    public void setLoteFechaVenc(Date loteFechaVenc) {
        this.loteFechaVenc = loteFechaVenc;
    }

    @Override
    public String toString() {
        return "Lote{" +
                ", producto=" + producto.getProdCodigo() +
                ", loteId=" + loteId +
                ", loteCodigo='" + loteCodigo + '\'' +
                ", loteCantidad=" + loteCantidad +
                ", loteFechaCreacion=" + loteFechaCreacion +
                ", loteFechaVenc=" + loteFechaVenc +
                '}';
    }
}
