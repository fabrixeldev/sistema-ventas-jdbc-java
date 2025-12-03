package modelo;

public class Laboratorio {

    private int labId;
    private String labNombre;
    private String labDescripcion;

    public Laboratorio(int labId, String labNombre, String labDescripcion){
        this.labId = labId;
        this.labNombre = labNombre;
        this.labDescripcion = labDescripcion;
    }

    public Laboratorio (){

    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLabNombre() {
        return labNombre;
    }

    public void setLabNombre(String labNombre) {
        this.labNombre = labNombre;
    }

    public String getLabDescripcion() {
        return labDescripcion;
    }

    public void setLabDescripcion(String labDescripcion) {
        this.labDescripcion = labDescripcion;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "labId=" + labId +
                ", labNombre='" + labNombre + '\'' +
                ", labDescripcion='" + labDescripcion + '\'' +
                '}';
    }
}
