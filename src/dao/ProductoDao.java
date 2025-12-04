package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductoDao {

    public void agregarProductos(Producto p){
        String sql = "INSERT INTO producto (producto_codigo, producto_nombre, producto_concentracion, producto_adicional, producto_imagen, producto_precio, prod_id_categ, prod_id_lab, prod_id_prese) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getProdCodigo());
            ps.setString(2, p.getProdNombre());
            ps.setString(3, p.getProdConcentracion());
            ps.setString(4, p.getProdAdicional());
            ps.setBytes(5, p.getProdImagen());
            ps.setDouble(6, p.getProdPrecio());
            ps.setInt(7, p.getCategoria().getCateId());
            ps.setInt(8, p.getLaboratorio().getLabId());
            ps.setInt(9, p.getPresentacion().getPresId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listarProductos(){
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT prod.*, cat.categoria_id, lab.laboratorio_id, pres.presentacion_id FROM producto prod INNER JOIN categoria cat ON prod_id_categ = categoria_id INNER JOIN laboratorio lab ON prod_id_lab = laboratorio_id INNER JOIN presentacion pres ON prod_id_prese = presentacion_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Producto producto = new Producto();
                Categoria categoria = new Categoria();
                Laboratorio laboratorio = new Laboratorio();
                Presentacion presentacion = new Presentacion();
                producto.setProdId(rs.getInt("producto_id"));
                producto.setProdCodigo(rs.getString("producto_codigo"));
                producto.setProdNombre(rs.getString("producto_nombre"));
                producto.setProdConcentracion(rs.getString("producto_concentracion"));
                producto.setProdAdicional(rs.getString("producto_adicional"));
                producto.setProdImagen(rs.getBytes("producto_imagen"));
                producto.setProdPrecio(rs.getDouble("producto_precio"));
                categoria.setCateId(rs.getInt("prod_id_categ"));
                laboratorio.setLabId(rs.getInt("prod_id_lab"));
                presentacion.setPresId(rs.getInt("prod_id_prese"));
                producto.setCategoria(categoria);
                producto.setLaboratorio(laboratorio);
                producto.setPresentacion(presentacion);
                lista.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarProductos(Producto p){
        String sql = "UPDATE producto SET producto_codigo = ?, producto_nombre = ?, producto_concentracion = ?, producto_adicional = ?, producto_imagen = ?, producto_precio = ?, prod_id_categ = ?, prod_id_lab = ?, prod_id_prese = ? WHERE producto_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getProdCodigo());
            ps.setString(2, p.getProdNombre());
            ps.setString(3, p.getProdConcentracion());
            ps.setString(4, p.getProdAdicional());
            ps.setBytes(5, p.getProdImagen());
            ps.setDouble(6, p.getProdPrecio());
            ps.setInt(7, p.getCategoria().getCateId());
            ps.setInt(8, p.getLaboratorio().getLabId());
            ps.setInt(9, p.getPresentacion().getPresId());
            ps.setInt(10, p.getProdId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarProductos(int prodId){
        String sql = "DELETE FROM producto WHERE producto_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, prodId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> buscarProducto(String prodNombre){
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT prod.*, cat.categoria_id, lab.laboratorio_id, pres.presentacion_id FROM producto prod INNER JOIN categoria cat ON prod_id_categ = categoria_id INNER JOIN laboratorio lab ON prod_id_lab = laboratorio_id INNER JOIN presentacion pres ON prod_id_prese = presentacion_id WHERE producto_nombre = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, prodNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Producto producto = new Producto();
                    Categoria categoria = new Categoria();
                    Laboratorio laboratorio = new Laboratorio();
                    Presentacion presentacion = new Presentacion();
                    producto.setProdId(rs.getInt("producto_id"));
                    producto.setProdCodigo(rs.getString("producto_codigo"));
                    producto.setProdNombre(rs.getString("producto_nombre"));
                    producto.setProdConcentracion(rs.getString("producto_concentracion"));
                    producto.setProdAdicional(rs.getString("producto_adicional"));
                    producto.setProdImagen(rs.getBytes("producto_imagen"));
                    producto.setProdPrecio(rs.getDouble("producto_precio"));
                    categoria.setCateId(rs.getInt("prod_id_categ"));
                    laboratorio.setLabId(rs.getInt("prod_id_lab"));
                    presentacion.setPresId(rs.getInt("prod_id_prese"));
                    producto.setCategoria(categoria);
                    producto.setLaboratorio(laboratorio);
                    producto.setPresentacion(presentacion);
                    lista.add(producto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Producto obtenerProductoPorId(int prodId){
        String sql = "SELECT prod.*, cat.categoria_id, lab.laboratorio_id, pres.presentacion_id FROM producto prod INNER JOIN categoria cat ON prod_id_categ = categoria_id INNER JOIN laboratorio lab ON prod_id_lab = laboratorio_id INNER JOIN presentacion pres ON prod_id_prese = presentacion_id WHERE producto_id = ?";
        Producto producto = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, prodId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    producto = new Producto();
                    Categoria categoria = new Categoria();
                    Laboratorio laboratorio = new Laboratorio();
                    Presentacion presentacion = new Presentacion();
                    producto.setProdId(rs.getInt("producto_id"));
                    producto.setProdCodigo(rs.getString("producto_codigo"));
                    producto.setProdNombre(rs.getString("producto_nombre"));
                    producto.setProdConcentracion(rs.getString("producto_concentracion"));
                    producto.setProdAdicional(rs.getString("producto_adicional"));
                    producto.setProdImagen(rs.getBytes("producto_imagen"));
                    producto.setProdPrecio(rs.getDouble("producto_precio"));
                    categoria.setCateId(rs.getInt("prod_id_categ"));
                    laboratorio.setLabId(rs.getInt("prod_id_lab"));
                    presentacion.setPresId(rs.getInt("prod_id_prese"));
                    producto.setCategoria(categoria);
                    producto.setLaboratorio(laboratorio);
                    producto.setPresentacion(presentacion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }
}
