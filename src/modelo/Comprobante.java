package modelo;

public class Comprobante {

    private Venta venta;

    private int comprobId;
    private String comprobCodigo;
    private String comprobTipo;
    private String comprobSerie;
    private boolean comprobEstado;

    public Comprobante (int comprobId, String comprobCodigo, String comprobTipo, String comprobSerie, boolean comprobEstado, Venta venta){
        this.comprobId = comprobId;
        this.comprobCodigo = comprobCodigo;
        this.comprobTipo = comprobTipo;
        this.comprobSerie = comprobSerie;
        this.comprobEstado = comprobEstado;
        this.venta = venta;
    }

    public Comprobante (){

    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getComprobId() {
        return comprobId;
    }

    public void setComprobId(int comprobId) {
        this.comprobId = comprobId;
    }

    public String getComprobCodigo() {
        return comprobCodigo;
    }

    public void setComprobCodigo(String comprobCodigo) {
        this.comprobCodigo = comprobCodigo;
    }

    public String getComprobTipo() {
        return comprobTipo;
    }

    public void setComprobTipo(String comprobTipo) {
        this.comprobTipo = comprobTipo;
    }

    public String getComprobSerie() {
        return comprobSerie;
    }

    public void setComprobSerie(String comprobSerie) {
        this.comprobSerie = comprobSerie;
    }

    public boolean isComprobEstado() {
        return comprobEstado;
    }

    public void setComprobEstado(boolean comprobEstado) {
        this.comprobEstado = comprobEstado;
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                " venta=" + venta.getVentId() +
                ", comprobId=" + comprobId +
                ", comprobCodigo='" + comprobCodigo + '\'' +
                ", comprobTipo='" + comprobTipo + '\'' +
                ", comprobSerie='" + comprobSerie + '\'' +
                ", comprobEstado=" + comprobEstado +
                '}';
    }
}
