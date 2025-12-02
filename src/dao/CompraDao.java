package dao;

import modelo.Compra;
import modelo.Conexion;
import modelo.Proveedor;
import modelo.Usuario;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {

    public void agregarCompra(Compra c){
        String sql = "INSERT INTO compra (compra_codigo, compra_numComprobante, compra_fecha, compra_total , compra_estado, compra_id_usuario, compra_id_proveedor) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCompraCodigo());
            ps.setString(2, c.getCompraNumComp());
            ps.setTimestamp(3, Timestamp.valueOf(c.getCompraFecha()));
            ps.setDouble(4, c.getCompraTotal());
            ps.setBoolean(5, c.isCompraEstado());
            ps.setInt(6, c.getUsuario().getUsuId());
            ps.setInt(7, c.getProveedor().getProvId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Compra> listarCompra (){
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT c.*, u.usuario_id, p.proveedor_id FROM compra c INNER JOIN usuario u ON compra_id_usuario = usuario_id INNER JOIN proveedor p ON compra_id_proveedor = proveedor_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                Compra c = new Compra();
                Usuario u = new Usuario();
                Proveedor p = new Proveedor();
                c.setCompraId(rs.getInt("compra_id"));
                c.setCompraCodigo(rs.getString("compra_codigo"));
                c.setCompraNumComp(rs.getString("compra_numComprobante"));
                c.setCompraFecha(rs.getTimestamp("compra_fecha").toLocalDateTime());
                c.setCompraTotal(rs.getDouble("compra_total"));
                c.setCompraEstado(rs.getBoolean("compra_estado"));
                u.setUsuId(rs.getInt("usuario_id"));
                p.setProvId(rs.getInt("proveedor_id"));
                c.setUsuario(u);
                c.setProveedor(p);
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarCompra(Compra c){
        String sql = "UPDATE compra SET compra_codigo = ?, compra_numComprobante = ?, compra_fecha = ?, compra_total = ?, compra_estado = ?, compra_id_usuario = ?, compra_id_proveedor = ? WHERE compra_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCompraCodigo());
            ps.setString(2, c.getCompraNumComp());
            ps.setTimestamp(3, Timestamp.valueOf(c.getCompraFecha()));
            ps.setDouble(4, c.getCompraTotal());
            ps.setBoolean(5, c.isCompraEstado());
            ps.setInt(6, c.getUsuario().getUsuId());
            ps.setInt(7, c.getProveedor().getProvId());
            ps.setInt(8, c.getCompraId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCompra(int compraId){
        String sql = "DELETE FROM compra WHERE compra_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, compraId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Compra> buscarCompra(String compraCodigo){
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT c.*, u.usuario_id, p.proveedor_id FROM compra c INNER JOIN usuario u ON compra_id_usuario = usuario_id INNER JOIN proveedor p ON compra_id_proveedor = proveedor_id WHERE compra_codigo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, compraCodigo);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Compra c = new Compra();
                    Usuario u = new Usuario();
                    Proveedor p = new Proveedor();
                    c.setCompraId(rs.getInt("compra_id"));
                    c.setCompraCodigo(rs.getString("compra_codigo"));
                    c.setCompraNumComp(rs.getString("compra_numComprobante"));
                    c.setCompraFecha(rs.getTimestamp("compra_fecha").toLocalDateTime());
                    c.setCompraTotal(rs.getDouble("compra_total"));
                    c.setCompraEstado(rs.getBoolean("compra_estado"));
                    u.setUsuId(rs.getInt("usuario_id"));
                    p.setProvId(rs.getInt("proveedor_id"));
                    c.setUsuario(u);
                    c.setProveedor(p);
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Compra obtenerCompraPorId(int compraId){
        String sql = "SELECT c.*, u.usuario_id, p.proveedor_id FROM compra c INNER JOIN usuario u ON compra_id_usuario = usuario_id INNER JOIN proveedor p ON compra_id_proveedor = proveedor_id WHERE compra_id = ?";
        Compra compra = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, compraId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    compra = new Compra();
                    Usuario u = new Usuario();
                    Proveedor p = new Proveedor();
                    compra.setCompraId(rs.getInt("compra_id"));
                    compra.setCompraCodigo(rs.getString("compra_codigo"));
                    compra.setCompraNumComp(rs.getString("compra_numComprobante"));
                    compra.setCompraFecha(rs.getTimestamp("compra_fecha").toLocalDateTime());
                    compra.setCompraTotal(rs.getDouble("compra_total"));
                    compra.setCompraEstado(rs.getBoolean("compra_estado"));
                    u.setUsuId(rs.getInt("usuario_id"));
                    p.setProvId(rs.getInt("proveedor_id"));
                    compra.setUsuario(u);
                    compra.setProveedor(p);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compra;
    }
}
