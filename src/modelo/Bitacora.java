package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bitacora {

    private Usuario usuario;

    private int bitaId;
    private String bitaCod;
    private LocalDate bitaFecha;
    private LocalTime bitaHoraInicio;
    private LocalTime bitaHoraFin;
    private String bitaTipoUsu;
    private LocalDate bitaAno;

    public Bitacora(int bitaId, String bitaCod, LocalDate bitaFecha, LocalTime bitaHoraInicio, LocalTime bitaHoraFin, String bitaTipoUsu, LocalDate bitaAno, Usuario usuario){
        this.bitaId = bitaId;
        this.bitaCod = bitaCod;
        this.bitaFecha = bitaFecha;
        this.bitaHoraInicio = bitaHoraInicio;
        this.bitaHoraFin = bitaHoraFin;
        this.bitaTipoUsu = bitaTipoUsu;
        this.bitaAno = bitaAno;
        this.usuario = usuario;
    }

    public Bitacora(){

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

    public LocalTime getBitaHoraInicio() {
        return bitaHoraInicio;
    }

    public void setBitaHoraInicio(LocalTime bitaHoraInicio) {
        this.bitaHoraInicio = bitaHoraInicio;
    }

    public LocalDate getBitaFecha() {
        return bitaFecha;
    }

    public void setBitaFecha(LocalDate bitaFecha) {
        this.bitaFecha = bitaFecha;
    }

    public LocalTime getBitaHoraFin() {
        return bitaHoraFin;
    }

    public void setBitaHoraFin(LocalTime bitaHoraFin) {
        this.bitaHoraFin = bitaHoraFin;
    }

    public LocalDate getBitaAno() {
        return bitaAno;
    }

    public void setBitaAno(LocalDate bitaAno) {
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
                ", bitaAno=" + bitaAno.getYear() +
                '}';
    }
}
