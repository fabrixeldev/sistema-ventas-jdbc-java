package dao;

import modelo.Cliente;
import modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao {

    public void agregarCliente(Cliente c){
        String sql = "INSERT INTO cliente (cliente_nombre, cliente_apellido, cliente_ci, cliente_celular, cliente_direccion, cliente_correoElectronico) VALUES (?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCliNombre());
            ps.setString(2, c.getCliApellido());
            ps.setString(3, c.getCliCI());
            ps.setInt(4, c.getCliCelular());
            ps.setString(5, c.getCliDireccion());
            ps.setString(6, c.getCliCorreoElec());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarClientes (){
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCliId(rs.getInt("cliente_id"));
                c.setCliNombre(rs.getString("cliente_nombre"));
                c.setCliApellido(rs.getString("cliente_apellido"));
                c.setCliCI(rs.getString("cliente_ci"));
                c.setCliCelular(rs.getInt("cliente_celular"));
                c.setCliDireccion(rs.getString("cliente_direccion"));
                c.setCliCorreoElec(rs.getString("cliente_correoElectronico"));

                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarClientes(Cliente c){
        String sql = "UPDATE cliente SET cliente_nombre = ?, cliente_apellido = ?, cliente_ci = ?, cliente_celular = ?, cliente_direccion = ?, cliente_correoElectronico = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, c.getCliNombre());
            ps.setString(2, c.getCliApellido());
            ps.setString(3, c.getCliCI());
            ps.setInt(4, c.getCliCelular());
            ps.setString(5, c.getCliDireccion());
            ps.setString(6, c.getCliCorreoElec());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarClientes(int cliId){
        String sql = "DELETE FROM cliente WHERE cliente_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, cliId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> buscarCliente(String cliCI){
        String sql = "SELECT * FROM cliente WHERE cliente_id = ?";
        List<Cliente> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, cliCI);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Cliente c = new Cliente();
                    c.setCliId(rs.getInt("cliente_id"));
                    c.setCliNombre(rs.getString("cliente_nombre"));
                    c.setCliApellido(rs.getString("cliente_apellido"));
                    c.setCliCI(rs.getString("cliente_ci"));
                    c.setCliCelular(rs.getInt("cliente_celular"));
                    c.setCliDireccion(rs.getString("cliente_direccion"));
                    c.setCliCorreoElec(rs.getString("cliente_correoElectronico"));
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Cliente obtenerClientePorId(int cliId){
        String sql = "SELECT * FROM cliente WHERE cliente_id = ?";
        Cliente cliente = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, cliId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    cliente = new Cliente();
                    cliente.setCliId(rs.getInt("cliente_id"));
                    cliente.setCliNombre(rs.getString("cliente_nombre"));
                    cliente.setCliApellido(rs.getString("cliente_apellido"));
                    cliente.setCliCI(rs.getString("cliente_ci"));
                    cliente.setCliCelular(rs.getInt("cliente_celular"));
                    cliente.setCliDireccion(rs.getString("cliente_direccion"));
                    cliente.setCliCorreoElec(rs.getString("cliente_correoElectronico"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
