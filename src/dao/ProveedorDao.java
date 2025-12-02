package dao;

import modelo.Conexion;
import modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {

    public void agregarProveedor (Proveedor p){
        String sql = "INSERT INTO proveedor (proveedor_codigo, proveedor_nombre, proveedor_tipoDocumento, proveedor_numDocumento, proveedor_celular, proveedor_direccion, proveedor_correoElectronico) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getProvCodigo());
            ps.setString(2, p.getProvNombre());
            ps.setString(3, p.getProvTipDoc());
            ps.setString(4, p.getProvNumDoc());
            ps.setInt(5, p.getProvCelular());
            ps.setString(6, p.getProvDireccion());
            ps.setString(7, p.getProvCorrElectr());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Proveedor> listarProveedor (){
        String sql = "SELECT * FROM proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Proveedor p = new Proveedor();
                p.setProvId(rs.getInt("proveedor_id"));
                p.setProvCodigo(rs.getString("proveedor_codigo"));
                p.setProvNombre(rs.getString("proveedor_nombre"));
                p.setProvTipDoc(rs.getString("proveedor_tipoDocumento"));
                p.setProvNumDoc(rs.getString("proveedor_numDocumento"));
                p.setProvCelular(rs.getInt("proveedor_celular"));
                p.setProvDireccion(rs.getString("proveedor_direccion"));
                p.setProvCorrElectr(rs.getString("proveedor_correoElectronico"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarProveedor(Proveedor p){
        String sql = "UPDATE proveedor SET proveedor_codigo = ?, proveedor_nombre = ?, proveedor_tipoDocumento = ?, proveedor_numDocumento = ?, proveedor_celular = ?, proveedor_direccion = ?, proveedor_correoElectronico = ? WHERE proveedor_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getProvCodigo());
            ps.setString(2, p.getProvNombre());
            ps.setString(3, p.getProvTipDoc());
            ps.setString(4, p.getProvNumDoc());
            ps.setInt(5, p.getProvCelular());
            ps.setString(6, p.getProvDireccion());
            ps.setString(7, p.getProvCorrElectr());
            ps.setInt(8, p.getProvId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarProveedor(int provId){
        String sql = "DELETE FROM proveedor WHERE proveedor_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, provId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Proveedor> buscarProveedor(String provNombre){
        String sql = "SELECT * FROM proveedor WHERE proveedor_nombre = ?";
        List<Proveedor> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, provNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Proveedor p = new Proveedor();
                    p.setProvId(rs.getInt("proveedor_id"));
                    p.setProvCodigo(rs.getString("proveedor_codigo"));
                    p.setProvNombre(rs.getString("proveedor_nombre"));
                    p.setProvTipDoc(rs.getString("proveedor_tipoDocumento"));
                    p.setProvNumDoc(rs.getString("proveedor_numDocumento"));
                    p.setProvCelular(rs.getInt("proveedor_celular"));
                    p.setProvDireccion(rs.getString("proveedor_direccion"));
                    p.setProvCorrElectr(rs.getString("proveedor_correoElectronico"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Proveedor obtenerProveedorPorId(int provId){
        String sql = "SELECT * FROM proveedor WHERE proveedor_id = ?";
        Proveedor proveedor = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, provId);
            try (ResultSet rs = ps.executeQuery()){
                proveedor = new Proveedor();
                proveedor.setProvId(rs.getInt("proveedor_id"));
                proveedor.setProvCodigo(rs.getString("proveedor_codigo"));
                proveedor.setProvNombre(rs.getString("proveedor_nombre"));
                proveedor.setProvTipDoc(rs.getString("proveedor_tipoDocumento"));
                proveedor.setProvNumDoc(rs.getString("proveedor_numDocumento"));
                proveedor.setProvCelular(rs.getInt("proveedor_celular"));
                proveedor.setProvDireccion(rs.getString("proveedor_direccion"));
                proveedor.setProvCorrElectr(rs.getString("proveedor_correoElectronico"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proveedor;
    }
}
