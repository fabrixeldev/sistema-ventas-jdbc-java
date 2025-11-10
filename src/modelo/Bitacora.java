package modelo;

import java.util.Date;

public class Bitacora {

    private Usuario usuario;

    private int bitaId;
    private String bitaCod;
    private Date bitaFecha;
    private Date bitaHoraInicio;
    private Date bitaHoraFin;
    private String bitaTipoUsu;
    private Date bitaAno;

    public Bitacora(int bitaId, String bitaCod, Date bitaFecha, Date bitaHoraInicio, Date bitaHoraFin, String bitaTipoUsu, Date bitaAno, Usuario usuario){
        this.bitaId = bitaId;
        this.bitaCod = bitaCod;
        this.bitaFecha = bitaFecha;
        this.bitaHoraInicio = bitaHoraInicio;
        this.bitaHoraFin = bitaHoraFin;
        this.bitaTipoUsu = bitaTipoUsu;
        this.bitaAno = bitaAno;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getBitaId() {
        return bitaId;
    }

    public void setBitaId(int bitaId) {
        this.bitaId = bitaId;
    }

    public String getBitaCod() {
        return bitaCod;
    }

    public void setBitaCod(String bitaCod) {
        this.bitaCod = bitaCod;
    }

    public Date getBitaHoraInicio() {
        return bitaHoraInicio;
    }

    public void setBitaHoraInicio(Date bitaHoraInicio) {
        this.bitaHoraInicio = bitaHoraInicio;
    }

    public Date getBitaFecha() {
        return bitaFecha;
    }

    public void setBitaFecha(Date bitaFecha) {
        this.bitaFecha = bitaFecha;
    }

    public Date getBitaHoraFin() {
        return bitaHoraFin;
    }

    public void setBitaHoraFin(Date bitaHoraFin) {
        this.bitaHoraFin = bitaHoraFin;
    }

    public Date getBitaAno() {
        return bitaAno;
    }

    public void setBitaAno(Date bitaAno) {
        this.bitaAno = bitaAno;
    }

    public String getBitaTipoUsu() {
        return bitaTipoUsu;
    }

    public void setBitaTipoUsu(String bitaTipoUsu) {
        this.bitaTipoUsu = bitaTipoUsu;
    }

    @Override
    public String toString() {
        return "Bitacora{" +
                "usuario=" + usuario.getUsuCodigo() +
                ", bitaId=" + bitaId +
                ", bitaCod='" + bitaCod + '\'' +
                ", bitaFecha=" + bitaFecha +
                ", bitaHoraInicio=" + bitaHoraInicio +
                ", bitaHoraFin=" + bitaHoraFin +
                ", bitaTipoUsu='" + bitaTipoUsu + '\'' +
                ", bitaAno=" + bitaAno +
                '}';
    }
}
