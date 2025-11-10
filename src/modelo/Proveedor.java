package modelo;

public class Proveedor {

    private int provId;
    private String provCodigo;
    private String provNombre;
    private String provTipDoc;
    private String provNumDoc;
    private int provCelular;
    private String provDireccion;
    private String provCorrElectr;

    public Proveedor (int provId, String provCodigo, String provNombre, String provTipDoc, String provNumDoc, int provCelular, String provDireccion, String provCorrElectr){
        this.provId = provId;
        this.provNombre = provNombre;
        this.provTipDoc = provTipDoc;
        this.provNumDoc = provNumDoc;
        this.provCelular = provCelular;
        this.provDireccion = provDireccion;
        this.provCorrElectr = provCorrElectr;
    }

    public int getProvId() {
        return provId;
    }

    public void setProvId(int provId) {
        this.provId = provId;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    public String getProvTipDoc() {
        return provTipDoc;
    }

    public void setProvTipDoc(String provTipDoc) {
        this.provTipDoc = provTipDoc;
    }

    public String getProvNumDoc() {
        return provNumDoc;
    }

    public void setProvNumDoc(String provNumDoc) {
        this.provNumDoc = provNumDoc;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public int getProvCelular() {
        return provCelular;
    }

    public void setProvCelular(int provCelular) {
        this.provCelular = provCelular;
    }

    public String getProvCorrElectr() {
        return provCorrElectr;
    }

    public void setProvCorrElectr(String provCorrElectr) {
        this.provCorrElectr = provCorrElectr;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "provId=" + provId +
                ", provCodigo='" + provCodigo + '\'' +
                ", provNombre='" + provNombre + '\'' +
                ", provTipDoc='" + provTipDoc + '\'' +
                ", provNumDoc='" + provNumDoc + '\'' +
                ", provCelular=" + provCelular +
                ", provDireccion='" + provDireccion + '\'' +
                ", provCorrElectr='" + provCorrElectr + '\'' +
                '}';
    }
}
