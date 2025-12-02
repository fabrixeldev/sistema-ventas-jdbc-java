package modelo;

public class DetalleVenta {

    private Venta venta;

    private int detVenId;
    private double detVenPrecio;
    private double detVenDescuento;

    public DetalleVenta (int detVenId, double detVenPrecio, double detVenDescuento, Venta venta){
        this.detVenId = detVenId;
        this.detVenPrecio = detVenPrecio;
        this.detVenDescuento = detVenDescuento;
        this.venta = venta;
    }

    public DetalleVenta (){

    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getDetVenId() {
        return detVenId;
    }

    public void setDetVenId(int detVenId) {
        this.detVenId = detVenId;
    }

    public double getDetVenPrecio() {
        return detVenPrecio;
    }

    public void setDetVenPrecio(double detVenPrecio) {
        this.detVenPrecio = detVenPrecio;
    }

    public double getDetVenDescuento() {
        return detVenDescuento;
    }

    public void setDetVenDescuento(double detVenDescuento) {
        this.detVenDescuento = detVenDescuento;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "detVenId=" + detVenId +
                ", detVenPrecio=" + detVenPrecio +
                ", detVenDescuento=" + detVenDescuento +
                ", venta=" + venta.getVentId() +
                '}';
    }
}
