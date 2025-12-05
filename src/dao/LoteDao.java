package dao;

import modelo.Conexion;
import modelo.Lote;
import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoteDao {

    public void agregarLote(Lote lote){
        String sql = "INSERT INTO lote (lote_codigo, lote_cantidad, lote_fechaCreacion, lote_fechaVencimiento, lote_id_producto) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, lote.getLoteCodigo());
            ps.setInt(2, lote.getLoteCantidad());
            ps.setDate(3, Date.valueOf(lote.getLoteFechaCreacion()));
            ps.setDate(4, Date.valueOf(lote.getLoteFechaVenc()));
            ps.setInt(5, lote.getProducto().getProdId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lote> listarLote(){
        List<Lote> lista = new ArrayList<>();
        String sql = "SELECT l.*, p.producto_id FROM lote l INNER JOIN producto p ON lote_id_producto = producto_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Lote lote = new Lote();
                Producto p = new Producto();
                lote.setLoteId(rs.getInt("lote_id"));
                lote.setLoteCodigo(rs.getString("lote_codigo"));
                lote.setLoteCantidad(rs.getInt("lote_cantidad"));
                lote.setLoteFechaCreacion(rs.getDate("lote_fechaCreacion").toLocalDate());
                lote.setLoteFechaVenc(rs.getDate("lote_fechaVencimiento").toLocalDate());
                p.setProdId(rs.getInt("producto_id"));
                lote.setProducto(p);
                lista.add(lote);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarLote(Lote lote){
        String sql = "UPDATE lote SET lote_codigo = ?, lote_cantidad = ?, lote_fechaCreacion = ?, lote_fechaVencimiento = ?, lote_id_producto = ? WHERE lote_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, lote.getLoteCodigo());
            ps.setInt(2, lote.getLoteCantidad());
            ps.setDate(3, Date.valueOf(lote.getLoteFechaCreacion()));
            ps.setDate(4, Date.valueOf(lote.getLoteFechaVenc()));
            ps.setInt(5, lote.getProducto().getProdId());
            ps.setInt(6, lote.getLoteId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarLote(int loteId){
        String sql = "DELETE FROM lote WHERE lote_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, loteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lote> buscarLote(int loteId){
        List<Lote> lista = new ArrayList<>();
        String sql = "SELECT l.*, p.producto_id FROM lote l INNER JOIN producto p ON lote_id_producto = producto_id WHERE lote_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, loteId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Lote lote = new Lote();
                    Producto p = new Producto();
                    lote.setLoteId(rs.getInt("lote_id"));
                    lote.setLoteCodigo(rs.getString("lote_codigo"));
                    lote.setLoteCantidad(rs.getInt("lote_cantidad"));
                    lote.setLoteFechaCreacion(rs.getDate("lote_fechaCreacion").toLocalDate());
                    lote.setLoteFechaVenc(rs.getDate("lote_fechaVencimiento").toLocalDate());
                    p.setProdId(rs.getInt("producto_id"));
                    lote.setProducto(p);
                    lista.add(lote);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Lote obtenerLotePorId(int loteId){
        String sql = "SELECT l.*, p.producto_id FROM lote l INNER JOIN producto p ON lote_id_producto = producto_id WHERE lote_id = ?";
        Lote lote = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, loteId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    lote = new Lote();
                    Producto p = new Producto();
                    lote.setLoteId(rs.getInt("lote_id"));
                    lote.setLoteCodigo(rs.getString("lote_codigo"));
                    lote.setLoteCantidad(rs.getInt("lote_cantidad"));
                    lote.setLoteFechaCreacion(rs.getDate("lote_fechaCreacion").toLocalDate());
                    lote.setLoteFechaVenc(rs.getDate("lote_fechaVencimiento").toLocalDate());
                    p.setProdId(rs.getInt("producto_id"));
                    lote.setProducto(p);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lote;
    }
}
