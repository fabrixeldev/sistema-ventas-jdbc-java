package modelo;

public class Presentacion {

    private int presId;
    private String presNombre;
    private String presDescripcion;

    public Presentacion(int presId, String presNombre, String presDescripcion){
        this.presId = presId;
        this.presNombre = presNombre;
        this.presDescripcion = presDescripcion;
    }

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public String getPresNombre() {
        return presNombre;
    }

    public void setPresNombre(String presNombre) {
        this.presNombre = presNombre;
    }

    public String getPresDescripcion() {
        return presDescripcion;
    }

    public void setPresDescripcion(String presDescripcion) {
        this.presDescripcion = presDescripcion;
    }

    @Override
    public String toString() {
        return "Presentacion{" +
                "presId=" + presId +
                ", presNombre='" + presNombre + '\'' +
                ", presDescripcion='" + presDescripcion + '\'' +
                '}';
    }
}
