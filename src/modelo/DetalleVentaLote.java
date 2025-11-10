package modelo;

public class DetalleVentaLote {

    private Lote lote;
    private DetalleVenta detalleVenta;

    private int detVenLoteId;
    private int detVenLoteCantidad;

    public DetalleVentaLote (int detVenLoteId, int detVenLoteCantidad, Lote lote, DetalleVenta detalleVenta){
        this.detVenLoteId = detVenLoteId;
        this.detVenLoteCantidad = detVenLoteCantidad;
        this.lote = lote;
        this.detalleVenta = detalleVenta;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getDetVenLoteId() {
        return detVenLoteId;
    }

    public void setDetVenLoteId(int detVenLoteId) {
        this.detVenLoteId = detVenLoteId;
    }

    public int getDetVenLoteCantidad() {
        return detVenLoteCantidad;
    }

    public void setDetVenLoteCantidad(int detVenLoteCantidad) {
        this.detVenLoteCantidad = detVenLoteCantidad;
    }

    @Override
    public String toString() {
        return "DetalleVentaLote{" +
                "lote=" + lote.getLoteCodigo() +
                ", detalleVenta=" + detalleVenta.getDetVenId() +
                ", detVenLoteId=" + detVenLoteId +
                ", detVenLoteCantidad=" + detVenLoteCantidad +
                '}';
    }
}
