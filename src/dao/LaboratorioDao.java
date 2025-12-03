package dao;

import modelo.Conexion;
import modelo.Laboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDao {

    public void agregarLaboratorio(Laboratorio l){
        String sql = "INSERT INTO laboratorio (laboratorio_nombre, laboratorio_descripcion) VALUES (?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, l.getLabNombre());
            ps.setString(2, l.getLabDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Laboratorio> listarLaboratorio(){
        List<Laboratorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM laboratorio";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Laboratorio l = new Laboratorio();
                l.setLabId(rs.getInt("laboratorio_id"));
                l.setLabNombre(rs.getString("laboratorio_nombre"));
                l.setLabDescripcion(rs.getString("laboratorio_descripcion"));
                lista.add(l);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarLaboratorio(Laboratorio l){
        String sql = "UPDATE laboratorio SET laboratorio_nombre = ?, laboratorio_descripcion = ? WHERE laboratorio_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, l.getLabNombre());
            ps.setString(2, l.getLabDescripcion());
            ps.setInt(3, l.getLabId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarLaboratorio(int labId){
        String sql = "DELETE FROM laboratorio WHERE laboratorio_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, labId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Laboratorio> buscarLaboratorio(String labNombre){
        List<Laboratorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM laboratorio WHERE laboratorio_nombre = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, labNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Laboratorio l = new Laboratorio();
                    l.setLabId(rs.getInt("laboratorio_id"));
                    l.setLabNombre(rs.getString("laboratorio_nombre"));
                    l.setLabDescripcion(rs.getString("laboratorio_descripcion"));
                    lista.add(l);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Laboratorio obtenerLaboratorioPorId(int labId){
        String sql = "SELECT * FROM laboratorio WHERE laboratorio_id = ?";
        Laboratorio laboratorio = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, labId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    laboratorio = new Laboratorio();
                    laboratorio.setLabId(rs.getInt("laboratorio_id"));
                    laboratorio.setLabNombre(rs.getString("laboratorio_nombre"));
                    laboratorio.setLabDescripcion(rs.getString("laboratorio_descripcion"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return laboratorio;
    }
}
