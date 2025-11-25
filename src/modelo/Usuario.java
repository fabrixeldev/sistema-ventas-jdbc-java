package modelo;


import java.time.LocalDate;

public class Usuario {

    private int usuId;
    private String usuCodigo;
    private String usuNombre;
    private String usuApellido;
    private LocalDate usuFechaNac;
    private String usuProfesion;
    private String usuCI;
    private int usuCelular;
    private String usuGenero;
    private String usuCargo;
    private String usuLogin;
    private String usuContrasena;
    private boolean usuEstado;

    public Usuario (int usuId, String usuCodigo, String usuNombre, String usuApellido, LocalDate usuFechaNac, String usuProfesion, String usuCI, int usuCelular, String usuGenero, String usuCargo, String usuLogin, String usuContrasena, boolean usuEstado){
        this.usuId = usuId;
        this.usuCodigo = usuCodigo;
        this.usuCI = usuCI;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuFechaNac = usuFechaNac;
        this.usuProfesion = usuProfesion;
        this.usuCelular = usuCelular;
        this.usuGenero = usuGenero;
        this.usuCargo = usuCargo;
        this.usuLogin = usuLogin;
        this.usuContrasena = usuContrasena;
        this.usuEstado = usuEstado;
    }

    public Usuario(){

    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(String usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public LocalDate getUsuFechaNac() {
        return usuFechaNac;
    }

    public void setUsuFechaNac(LocalDate usuFechaNac) {
        this.usuFechaNac = usuFechaNac;
    }

    public String getUsuProfesion() {
        return usuProfesion;
    }

    public void setUsuProfesion(String usuProfesion) {
        this.usuProfesion = usuProfesion;
    }

    public String getUsuCI() {
        return usuCI;
    }

    public void setUsuCI(String usuCI) {
        this.usuCI = usuCI;
    }

    public int getUsuCelular() {
        return usuCelular;
    }

    public void setUsuCelular(int usuCelular) {
        this.usuCelular = usuCelular;
    }

    public String getUsuGenero() {
        return usuGenero;
    }

    public void setUsuGenero(String usuGenero) {
        this.usuGenero = usuGenero;
    }

    public String getUsuCargo() {
        return usuCargo;
    }

    public void setUsuCargo(String usuCargo) {
        this.usuCargo = usuCargo;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public boolean isUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuId=" + usuId +
                ", usuCodigo='" + usuCodigo + '\'' +
                ", usuNombre='" + usuNombre + '\'' +
                ", usuApellido='" + usuApellido + '\'' +
                ", usuFechaNac=" + usuFechaNac +
                ", usuProfesion='" + usuProfesion + '\'' +
                ", usuCI='" + usuCI + '\'' +
                ", usuCelular=" + usuCelular +
                ", usuGenero='" + usuGenero + '\'' +
                ", usuCargo='" + usuCargo + '\'' +
                ", usuLogin='" + usuLogin + '\'' +
                ", usuContrasena='" + usuContrasena + '\'' +
                ", usuEstado=" + usuEstado +
                '}';
    }
}
