package dao;

import modelo.Comprobante;
import modelo.Conexion;
import modelo.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteDao {

    public void agregarComprobante (Comprobante c){
        String sql = "INSERT INTO comprobante (comprobante_codigo, comprobante_tipo, comprobante_serie, comprobante_estado, comprobante_id_venta) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getComprobCodigo());
            ps.setString(2, c.getComprobTipo());
            ps.setString(3, c.getComprobSerie());
            ps.setBoolean(4, c.isComprobEstado());
            ps.setInt(5, c.getVenta().getVentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comprobante> listarComprobante (){
        List<Comprobante> lista = new ArrayList<>();
        String sql = "SELECT c.*, v.venta_id FROM comprobante c INNER JOIN venta v ON comprobante_id_venta = venta_id";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Comprobante c = new Comprobante();
                Venta v = new Venta();
                c.setComprobId(rs.getInt("comprobante_id"));
                c.setComprobCodigo(rs.getString("comprobante_codigo"));
                c.setComprobTipo(rs.getString("comprobante_tipo"));
                c.setComprobSerie(rs.getString("comprobante_serie"));
                c.setComprobEstado(rs.getBoolean("comprobante_estado"));
                v.setVentId(rs.getInt("venta_id"));
                c.setVenta(v);
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarComprobante (Comprobante c){
        String sql = "UPDATE comprobante SET comprobante_codigo = ?, comprobante_tipo = ?, comprobante_serie = ?, comprobante_estado = ?, comprobante_id_venta = ? WHERE comprobante_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getComprobCodigo());
            ps.setString(2, c.getComprobTipo());
            ps.setString(3, c.getComprobSerie());
            ps.setBoolean(4, c.isComprobEstado());
            ps.setInt(5, c.getVenta().getVentId());
            ps.setInt(6, c.getComprobId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarComprobante(int comprobId){
        String sql = "DELETE FROM comprobante WHERE comprobante_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, comprobId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comprobante> buscarComprobante (String comprobCodigo){
        String sql = "SELECT c.*, v.venta_id FROM comprobante c INNER JOIN venta v ON comprobante_id_venta = venta_id WHERE comprobante_codigo = ?";
        List<Comprobante> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, comprobCodigo);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Comprobante c = new Comprobante();
                    Venta v = new Venta();
                    c.setComprobId(rs.getInt("comprobante_id"));
                    c.setComprobCodigo(rs.getString("comprobante_codigo"));
                    c.setComprobTipo(rs.getString("comprobante_tipo"));
                    c.setComprobSerie(rs.getString("comprobante_serie"));
                    c.setComprobEstado(rs.getBoolean("comprobante_estado"));
                    v.setVentId(rs.getInt("venta_id"));
                    c.setVenta(v);
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
