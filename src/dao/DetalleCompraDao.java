package dao;

import modelo.Compra;
import modelo.Conexion;
import modelo.DetalleCompra;
import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDao {

    public void agregarDetalleCompra(DetalleCompra dc){
        String sql = "INSERT INTO detalleCompra (detalleCompra_cantidad, detalleCompra_precioCompra, detalleCompra_id_compra, detalleCompra_id_producto) VALUES (?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, dc.getDetCompCantidad());
            ps.setDouble(2, dc.getDetCompPrecio());
            ps.setInt(3, dc.getCompra().getCompraId());
            ps.setInt(4, dc.getProducto().getProdId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DetalleCompra> listarDetalleCompra(){
        List<DetalleCompra> lista = new ArrayList<>();
        String sql = "SELECT dc.*, c.compra_id, p.producto_id FROM detalleCompra dc INNER JOIN compra c ON detalleCompra_id_compra = compra_id INNER JOIN producto p ON detalleCompra_id_producto = producto_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                DetalleCompra dc = new DetalleCompra();
                Compra c = new Compra();
                Producto p = new Producto();
                dc.setDetCompId(rs.getInt("detalleCompra_id"));
                dc.setDetCompCantidad(rs.getInt("detalleCompra_cantidad"));
                dc.setDetCompPrecio(rs.getDouble("detalleCompra_precioCompra"));
                c.setCompraId(rs.getInt("compra_id"));
                p.setProdId(rs.getInt("producto_id"));
                dc.setCompra(c);
                dc.setProducto(p);
                lista.add(dc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarDetalleCompra(DetalleCompra dc){
        String sql = "UPDATE detalleCompra SET detalleCompra_cantidad = ?, detalleCompra_precioCompra = ?, detalleCompra_id_compra = ?, detalleCompra_id_producto = ? WHERE detalleCompra_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, dc.getDetCompCantidad());
            ps.setDouble(2, dc.getDetCompPrecio());
            ps.setInt(3, dc.getCompra().getCompraId());
            ps.setInt(4, dc.getProducto().getProdId());
            ps.setInt(5, dc.getDetCompId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarDetalleCompra(int detCompId){
        String sql = "DELETE FROM detalleCompra WHERE detalleCompra_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, detCompId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DetalleCompra> buscarDetalleCompra(int detCompId){
        List<DetalleCompra> lista = new ArrayList<>();
        String sql = "SELECT dc.*, c.compra_id, p.producto_id FROM detalleCompra dc INNER JOIN compra c ON detalleCompra_id_compra = compra_id INNER JOIN producto p ON detalleCompra_id_producto = producto_id WHERE detalleCompra_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, detCompId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    DetalleCompra dc = new DetalleCompra();
                    Compra c = new Compra();
                    Producto p = new Producto();
                    dc.setDetCompId(rs.getInt("detalleCompra_id"));
                    dc.setDetCompCantidad(rs.getInt("detalleCompra_cantidad"));
                    dc.setDetCompPrecio(rs.getDouble("detalleCompra_precioCompra"));
                    c.setCompraId(rs.getInt("compra_id"));
                    p.setProdId(rs.getInt("producto_id"));
                    dc.setCompra(c);
                    dc.setProducto(p);
                    lista.add(dc);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
