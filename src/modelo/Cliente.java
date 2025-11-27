package modelo;

public class Cliente {

    private int cliId;
    private String cliNombre;
    private String cliApellido;
    private String cliCI;
    private int cliCelular;
    private String cliDireccion;
    private String cliCorreoElec;

    public Cliente(int cliId, String cliNombre, String cliApellido, String cliCI, int cliCelular, String cliDireccion, String cliCorreoElec){
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliApellido = cliApellido;
        this.cliCI = cliCI;
        this.cliCelular = cliCelular;
        this.cliDireccion = cliDireccion;
        this.cliCorreoElec = cliCorreoElec;
    }

    public Cliente(){

    }

    public int getCliId() { return cliId; }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliCI() {
        return cliCI;
    }

    public void setCliCI(String cliCI) {
        this.cliCI = cliCI;
    }

    public int getCliCelular() { return cliCelular; }

    public void setCliCelular(int cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliCorreoElec() {
        return cliCorreoElec;
    }

    public void setCliCorreoElec(String cliCorreoElec) {
        this.cliCorreoElec = cliCorreoElec;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cliId=" + cliId +
                ", cliNombre='" + cliNombre + '\'' +
                ", cliApellido='" + cliApellido + '\'' +
                ", cliCI='" + cliCI + '\'' +
                ", cliCelular=" + cliCelular +
                ", cliDireccion='" + cliDireccion + '\'' +
                ", cliCorreoElec='" + cliCorreoElec + '\'' +
                '}';
    }
}
