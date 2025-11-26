package dao;


import modelo.Bitacora;
import modelo.Conexion;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BitacoraDao {

    public void agregarBitacora(Bitacora b){
        String sql = "INSERT INTO bitacora (bitacora_codigo, bitacora_fecha, bitacora_horaInicio, bitacora_horaFin, bitacora_tipoUsuario, bitacora_ano, bitacora_id_usuario) VALUES (?,?,?,?,?,?,?)";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, b.getBitaCod());
            ps.setDate(2, java.sql.Date.valueOf(b.getBitaFecha()));
            ps.setTime(3, java.sql.Time.valueOf(b.getBitaHoraInicio()));
            ps.setTime(4, java.sql.Time.valueOf(b.getBitaHoraFin()));
            ps.setString(5, b.getBitaTipoUsu());
            ps.setDate(6, Date.valueOf(b.getBitaAno()));
            ps.setInt(7, b.getUsuario().getUsuId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bitacora> listarBitacora (){
        List<Bitacora> lista = new ArrayList<>();
        String sql = "SELECT b.*, u.usuario_codigo FROM bitacora b INNER JOIN usuario u ON bitacora_id_usuario = usuario_id;";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Bitacora b = new Bitacora();
                Usuario u = new Usuario();
                b.setBitaId(rs.getInt("bitacora_id"));
                b.setBitaCod(rs.getString("bitacora_codigo"));
                b.setBitaFecha(rs.getDate("bitacora_fecha").toLocalDate());
                b.setBitaHoraInicio(rs.getTime("bitacora_horaInicio").toLocalTime());
                b.setBitaHoraFin(rs.getTime("bitacora_horaFin").toLocalTime());
                b.setBitaTipoUsu(rs.getString("bitacora_tipoUsuario"));
                b.setBitaAno(rs.getDate("bitacora_ano").toLocalDate());
                u.setUsuCodigo(rs.getString("usuario_codigo"));

                b.setUsuario(u);
                lista.add(b);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void eliminarBitacora (Bitacora b){
        String sql = "DELETE FROM bitacora WHERE bitacora_id = ?";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, b.getBitaId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bitacora> buscarBitacora(String bitaCod){
        String sql = "SELECT b.*, u.usuario_codigo FROM bitacora b INNER JOIN usuario u ON bitacora_id_usuario = usuario_id WHERE bitacora_codigo = ?";
        List<Bitacora> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, bitaCod);

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Bitacora b = new Bitacora();
                    Usuario u = new Usuario();
                    b.setBitaId(rs.getInt("bitacora_id"));
                    b.setBitaCod(rs.getString("bitacora_codigo"));
                    b.setBitaFecha(rs.getDate("bitacora_fecha").toLocalDate());
                    b.setBitaHoraInicio(rs.getTime("bitacora_horaInicio").toLocalTime());
                    b.setBitaHoraFin(rs.getTime("bitacora_horaFin").toLocalTime());
                    b.setBitaTipoUsu(rs.getString("bitacora_tipoUsuario"));
                    b.setBitaAno(rs.getDate("bitacora_ano").toLocalDate());
                    u.setUsuCodigo(rs.getString("usuario_codigo"));
                    b.setUsuario(u);
                    lista.add(b);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
