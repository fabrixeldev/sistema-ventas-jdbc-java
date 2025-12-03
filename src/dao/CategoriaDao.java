package dao;

import modelo.Categoria;
import modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    public void agregarCategoria(Categoria c){
        String sql = "INSERT INTO categoria (categoria_nombre, categoria_descripcion) VALUES (?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCateNombre());
            ps.setString(2, c.getCateDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarCategoria(){
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Categoria c = new Categoria();
                c.setCateId(rs.getInt("categoria_id"));
                c.setCateNombre(rs.getString("categoria_nombre"));
                c.setCateDescripcion(rs.getString("categoria_descripcion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarCategoria(Categoria c){
        String sql = "UPDATE categoria SET categoria_nombre = ?, categoria_descripcion = ? WHERE categoria_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCateNombre());
            ps.setString(2, c.getCateDescripcion());
            ps.setInt(3, c.getCateId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCategoria(int cateId){
        String sql = "DELETE FROM categoria WHERE categoria_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, cateId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> buscarCategoria(String cateNombre){
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria WHERE categoria_nombre = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, cateNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Categoria c = new Categoria();
                    c.setCateId(rs.getInt("categoria_id"));
                    c.setCateNombre(rs.getString("categoria_nombre"));
                    c.setCateDescripcion(rs.getString("categoria_descripcion"));
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Categoria obtenerCategoriaPorId(int cateId){
        String sql = "SELECT * FROM categoria WHERE categoria_id = ?";
        Categoria categoria = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, cateId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    categoria = new Categoria();
                    categoria.setCateId(rs.getInt("categoria_id"));
                    categoria.setCateNombre(rs.getString("categoria_nombre"));
                    categoria.setCateDescripcion(rs.getString("categoria_descripcion"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }
}
