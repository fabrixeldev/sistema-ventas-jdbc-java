package dao;

import modelo.Conexion;
import modelo.Presentacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresentacionDao {

    public void agregarPresentacion(Presentacion p) {
        String sql = "INSERT INTO presentacion (presentacion_nombre, presentacion_descripcion) VALUES (?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getPresNombre());
            ps.setString(2, p.getPresDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Presentacion> listarPresentacion() {
        List<Presentacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM presentacion";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Presentacion p = new Presentacion();
                p.setPresId(rs.getInt("presentacion_id"));
                p.setPresNombre(rs.getString("presentacion_nombre"));
                p.setPresDescripcion(rs.getString("presentacion_descripcion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarPresentacion(Presentacion p) {
        String sql = "UPDATE presentacion SET presentacion_nombre = ?, presentacion_descripcion = ? WHERE presentacion_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getPresNombre());
            ps.setString(2, p.getPresDescripcion());
            ps.setInt(3, p.getPresId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPresentacion(int presId){
        String sql = "DELETE FROM presentacion WHERE presentacion_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, presId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Presentacion> buscarPresentacion(String presNombre){
        List<Presentacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM presentacion WHERE presentacion_nombre = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, presNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Presentacion p = new Presentacion();
                    p.setPresId(rs.getInt("presentacion_id"));
                    p.setPresNombre(rs.getString("presentacion_nombre"));
                    p.setPresDescripcion(rs.getString("presentacion_descripcion"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Presentacion obtenerPresentacionPorId(int presId){
        String sql = "SELECT * FROM presentacion WHERE presentacion_id = ?";
        Presentacion presentacion = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, presId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    presentacion = new Presentacion();
                    presentacion.setPresId(rs.getInt("presentacion_id"));
                    presentacion.setPresNombre(rs.getString("presentacion_nombre"));
                    presentacion.setPresDescripcion(rs.getString("presentacion_descripcion"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return presentacion;
    }
}
