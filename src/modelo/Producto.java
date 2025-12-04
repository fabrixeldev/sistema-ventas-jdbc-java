package modelo;

import java.awt.image.BufferedImage;

public class Producto{
    private Categoria categoria;
    private Presentacion presentacion;
    private Laboratorio laboratorio;

    private int prodId;
    private String prodCodigo;
    private String prodNombre;
    private String prodConcentracion;
    private String prodAdicional;
    private byte[] prodImagen;
    private double prodPrecio;

    public Producto(int prodId, String prodCodigo, String prodNombre, String prodConcentracion, String prodAdicional, byte[] prodImagen, double prodPrecio, Categoria categoria, Presentacion presentacion, Laboratorio laboratorio){
        this.prodId = prodId;
        this.prodCodigo = prodCodigo;
        this.prodNombre = prodNombre;
        this.prodConcentracion = prodConcentracion;
        this.prodAdicional = prodAdicional;
        this.prodImagen = prodImagen;
        this.prodPrecio = prodPrecio;
        this.categoria = categoria;
        this.presentacion = presentacion;
        this.laboratorio = laboratorio;
    }

    public Producto (){

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdConcentracion() {
        return prodConcentracion;
    }

    public void setProdConcentracion(String prodConcentracion) {
        this.prodConcentracion = prodConcentracion;
    }

    public String getProdAdicional() {
        return prodAdicional;
    }

    public void setProdAdicional(String prodAdicional) {
        this.prodAdicional = prodAdicional;
    }

    public byte[] getProdImagen() {
        return prodImagen;
    }

    public void setProdImagen(byte[] prodImagen) {
        this.prodImagen = prodImagen;
    }

    public double getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(double prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                " prodId=" + prodId +
                ", prodCodigo='" + prodCodigo + '\'' +
                ", prodNombre='" + prodNombre + '\'' +
                ", prodConcentracion='" + prodConcentracion + '\'' +
                ", prodAdicional='" + prodAdicional + '\'' +
                ", prodImagen=" + prodImagen +
                ", prodPrecio=" + prodPrecio +
                ", categoria=" + categoria.getCateId() +
                ", presentacion=" + presentacion.getPresId() +
                ", laboratorio=" + laboratorio.getLabId() +
                '}';
    }
}
