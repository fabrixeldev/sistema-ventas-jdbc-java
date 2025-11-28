package dao;

import modelo.Cliente;
import modelo.Conexion;
import modelo.Usuario;
import modelo.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {

    public void agregarVenta(Venta v){
        String sql = "INSERT INTO venta (venta_codigo, venta_numComprobante, venta_fecha, venta_total, venta_estado, venta_id_usuario, venta_id_cliente) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, v.getVentCodigo());
            ps.setString(2, v.getVentNumCompro());
            ps.setTimestamp(3, Timestamp.valueOf(v.getVentFecha()));
            ps.setDouble(4, v.getVentTotal());
            ps.setBoolean(5, v.isVentEstado());
            ps.setInt(6, v.getUsuario().getUsuId());
            ps.setInt(7, v.getCliente().getCliId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Venta> listarVentas(){
        String sql = "SELECT v.*, u.usuario_id, c.cliente_id FROM venta v INNER JOIN usuario u ON venta_id_usuario = usuario_id INNER JOIN cliente c ON venta_id_cliente = cliente_id ORDER BY venta_id ASC";
        List<Venta> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Venta v = new Venta();
                Usuario u = new Usuario();
                Cliente c = new Cliente();
                v.setVentId(rs.getInt("venta_id"));
                v.setVentCodigo(rs.getString("venta_codigo"));
                v.setVentNumCompro(rs.getString("venta_numComprobante"));
                v.setVentFecha(rs.getTimestamp("venta_fecha").toLocalDateTime());
                v.setVentTotal(rs.getDouble("venta_total"));
                v.setVentEstado(rs.getBoolean("venta_estado"));
                u.setUsuId(rs.getInt("usuario_id"));
                c.setCliId(rs.getInt("cliente_id"));
                v.setUsuario(u);
                v.setCliente(c);
                lista.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarVenta(Venta v){
        String sql = "UPDATE venta SET venta_codigo = ?, venta_numComprobante = ?, venta_fecha = ?, venta_total = ?, venta_estado = ?, venta_id_usuario = ?, venta_id_cliente = ? WHERE venta_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, v.getVentCodigo());
            ps.setString(2, v.getVentNumCompro());
            ps.setTimestamp(3, Timestamp.valueOf(v.getVentFecha()));
            ps.setDouble(4, v.getVentTotal());
            ps.setBoolean(5, v.isVentEstado());
            ps.setInt(6, v.getUsuario().getUsuId());
            ps.setInt(7, v.getCliente().getCliId());
            ps.setInt(8, v.getVentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarVenta(int ventId){
        String sql = "DELETE FROM venta WHERE venta_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, ventId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Venta> buscarVenta(String ventCodigo){
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT v.*, u.usuario_id, c.cliente_id FROM venta v INNER JOIN usuario u ON venta_id_usuario = usuario_id INNER JOIN cliente c ON venta_id_cliente = cliente_id WHERE venta_codigo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, ventCodigo);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Venta v = new Venta();
                    Usuario u = new Usuario();
                    Cliente c = new Cliente();
                    v.setVentId(rs.getInt("venta_id"));
                    v.setVentCodigo(rs.getString("venta_codigo"));
                    v.setVentNumCompro(rs.getString("venta_numComprobante"));
                    v.setVentFecha(rs.getTimestamp("venta_fecha").toLocalDateTime());
                    v.setVentTotal(rs.getDouble("venta_total"));
                    v.setVentEstado(rs.getBoolean("venta_estado"));
                    u.setUsuId(rs.getInt("usuario_id"));
                    c.setCliId(rs.getInt("cliente_id"));
                    v.setUsuario(u);
                    v.setCliente(c);
                    lista.add(v);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Venta obtenerVentaPorId(int ventId){
        String sql = "SELECT v.*, u.usuario_id, c.cliente_id FROM venta v INNER JOIN usuario u ON venta_id_usuario = usuario_id INNER JOIN cliente c ON venta_id_cliente = cliente_id WHERE venta_id = ?";
        Venta venta = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, ventId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    venta = new Venta();
                    Usuario u = new Usuario();
                    Cliente c = new Cliente();
                    venta.setVentId(rs.getInt("venta_id"));
                    venta.setVentCodigo(rs.getString("venta_codigo"));
                    venta.setVentNumCompro(rs.getString("venta_numComprobante"));
                    venta.setVentFecha(rs.getTimestamp("venta_fecha").toLocalDateTime());
                    venta.setVentTotal(rs.getDouble("venta_total"));
                    venta.setVentEstado(rs.getBoolean("venta_estado"));
                    u.setUsuId(rs.getInt("usuario_id"));
                    c.setCliId(rs.getInt("cliente_id"));
                    venta.setUsuario(u);
                    venta.setCliente(c);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return venta;
    }
}
