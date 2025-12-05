package dao;

import modelo.Conexion;
import modelo.DetalleVenta;
import modelo.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDao {

    public void agregarDetalleVenta(DetalleVenta dv){
        String sql = "INSERT INTO detalleVenta (detalleVenta_precioVenta, detalleVenta_descuento, detalleVenta_id_venta) VALUES (?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setDouble(1, dv.getDetVenPrecio());
            ps.setDouble(2, dv.getDetVenDescuento());
            ps.setInt(3, dv.getVenta().getVentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DetalleVenta> listarDetalleVenta(){
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT dv.*, v.venta_id FROM detalleVenta dv INNER JOIN venta v ON detalleVenta_id_venta = venta_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                DetalleVenta dv = new DetalleVenta();
                Venta v = new Venta();
                dv.setDetVenId(rs.getInt("detalleVenta_id"));
                dv.setDetVenPrecio(rs.getDouble("detalleVenta_precioVenta"));
                dv.setDetVenDescuento(rs.getDouble("detalleVenta_descuento"));
                v.setVentId(rs.getInt("venta_id"));
                dv.setVenta(v);
                lista.add(dv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarDetalleVenta(DetalleVenta dv){
        String sql = "UPDATE detalleVenta SET detalleVenta_precioVenta = ?, detalleVenta_descuento = ?, detalleVenta_id_venta = ? WHERE detalleVenta_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setDouble(1, dv.getDetVenPrecio());
            ps.setDouble(2, dv.getDetVenDescuento());
            ps.setInt(3, dv.getVenta().getVentId());
            ps.setInt(4, dv.getDetVenId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarDetalleVenta(int detVenId){
        String sql = "DELETE FROM detalleVenta WHERE detalleVenta_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, detVenId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DetalleVenta> buscarDetalleVenta(int detVenId){
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT dv.*, v.venta_id FROM detalleVenta dv INNER JOIN venta v ON detalleVenta_id_venta = venta_id WHERE detalleVenta_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, detVenId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    DetalleVenta dv = new DetalleVenta();
                    Venta v = new Venta();
                    dv.setDetVenId(rs.getInt("detalleVenta_id"));
                    dv.setDetVenPrecio(rs.getDouble("detalleVenta_precioVenta"));
                    dv.setDetVenDescuento(rs.getDouble("detalleVenta_descuento"));
                    v.setVentId(rs.getInt("venta_id"));
                    dv.setVenta(v);
                    lista.add(dv);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public DetalleVenta obtenerDetalleVentaPorId(int detVenId){
        String sql = "SELECT dv.*, v.venta_id FROM detalleVenta dv INNER JOIN venta v ON detalleVenta_id_venta = venta_id WHERE detalleVenta_id = ?";
        DetalleVenta detalleVenta = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, detVenId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    detalleVenta = new DetalleVenta();
                    Venta venta = new Venta();
                    detalleVenta.setDetVenId(rs.getInt("detalleVenta_id"));
                    detalleVenta.setDetVenPrecio(rs.getDouble("detalleVenta_precioVenta"));
                    detalleVenta.setDetVenDescuento(rs.getDouble("detalleVenta_descuento"));
                    venta.setVentId(rs.getInt("venta_id"));
                    detalleVenta.setVenta(venta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return detalleVenta;
    }
}
