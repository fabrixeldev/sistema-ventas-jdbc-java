package modelo;

public class Categoria {

    private int cateId;
    private String cateNombre;
    private String cateDescripcion;

    public Categoria(int cateId, String cateNombre, String cateDescripcion){
        this.cateId = cateId;
        this.cateNombre = cateNombre;
        this.cateDescripcion = cateDescripcion;
    }

    public Categoria (){

    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateNombre() {
        return cateNombre;
    }

    public void setCateNombre(String cateNombre) {
        this.cateNombre = cateNombre;
    }

    public String getCateDescripcion() {
        return cateDescripcion;
    }

    public void setCateDescripcion(String cateDescripcion) {
        this.cateDescripcion = cateDescripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "cateId=" + cateId +
                ", cateNombre='" + cateNombre + '\'' +
                ", cateDescripcion='" + cateDescripcion + '\'' +
                '}';
    }
}
