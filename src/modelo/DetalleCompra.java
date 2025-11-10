package modelo;

public class DetalleCompra {

    private Compra compra;
    private Producto producto;

    private int detCompId;
    private int detCompCantidad;
    private double detCompPrecio;

    public DetalleCompra(int detCompId, int detCompCantidad, double detCompPrecio, Producto producto, Compra compra){
        this.detCompId = detCompId;
        this.detCompCantidad = detCompCantidad;
        this.detCompPrecio = detCompPrecio;
        this.producto = producto;
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getDetCompId() {
        return detCompId;
    }

    public void setDetCompId(int detCompId) {
        this.detCompId = detCompId;
    }

    public int getDetCompCantidad() {
        return detCompCantidad;
    }

    public void setDetCompCantidad(int detCompCantidad) {
        this.detCompCantidad = detCompCantidad;
    }

    public double getDetCompPrecio() {
        return detCompPrecio;
    }

    public void setDetCompPrecio(double detCompPrecio) {
        this.detCompPrecio = detCompPrecio;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                ", detCompId=" + detCompId +
                ", detCompCantidad=" + detCompCantidad +
                ", detCompPrecio=" + detCompPrecio +
                ", compra=" + compra +
                ", producto=" + producto +
                '}';
    }
}
