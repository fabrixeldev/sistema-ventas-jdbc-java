package dao;

import modelo.Conexion;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public void agregarUsuario (Usuario u){
        String sql = "INSERT INTO usuario (usuario_codigo, usuario_nombre, usuario_apellido , usuario_fechaNacimiento ,usuario_profesion, usuario_ci, usuario_celular, usuario_genero, usuario_cargo , usuario_login , usuario_constrasena , usuario_estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, u.getUsuCodigo());
            ps.setString(2, u.getUsuNombre());
            ps.setString(3, u.getUsuApellido());
            ps.setDate(4, java.sql.Date.valueOf(u.getUsuFechaNac()));
            ps.setString(5, u.getUsuProfesion());
            ps.setString(6, u.getUsuCI());
            ps.setInt(7, u.getUsuCelular());
            ps.setString(8, u.getUsuGenero());
            ps.setString(9, u.getUsuCargo());
            ps.setString(10, u.getUsuLogin());
            ps.setString(11, u.getUsuContrasena());
            ps.setBoolean(12, u.isUsuEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Usuario u = new Usuario();
                u.setUsuId(rs.getInt("usuario_id"));
                u.setUsuCodigo(rs.getString("usuario_codigo"));
                u.setUsuNombre(rs.getString("usuario_nombre"));
                u.setUsuApellido(rs.getString("usuario_apellido"));
                u.setUsuFechaNac(rs.getDate("usuario_fechaNacimiento").toLocalDate());
                u.setUsuProfesion(rs.getString("usuario_profesion"));
                u.setUsuCI(rs.getString("usuario_ci"));
                u.setUsuCelular(rs.getInt("usuario_celular"));
                u.setUsuGenero(rs.getString("usuario_genero"));
                u.setUsuCargo(rs.getString("usuario_cargo"));
                u.setUsuLogin(rs.getString("usuario_login"));
                u.setUsuContrasena(rs.getString("usuario_constrasena"));
                u.setUsuEstado(rs.getBoolean("usuario_estado"));

                lista.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void editarUsuarios(Usuario u){
        String sql = "UPDATE usuario SET usuario_codigo = ?, usuario_nombre = ?, usuario_apellido = ?, usuario_fechaNacimiento = ?, usuario_profesion = ?, usuario_ci = ?, usuario_celular = ?, usuario_genero = ?, usuario_cargo = ?, usuario_login = ?, usuario_constrasena = ?, usuario_estado = ? WHERE usuario_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, u.getUsuCodigo());
            ps.setString(2, u.getUsuNombre());
            ps.setString(3, u.getUsuApellido());
            ps.setDate(4, java.sql.Date.valueOf(u.getUsuFechaNac()));
            ps.setString(5, u.getUsuProfesion());
            ps.setString(6, u.getUsuCI());
            ps.setInt(7, u.getUsuCelular());
            ps.setString(8, u.getUsuGenero());
            ps.setString(9, u.getUsuCargo());
            ps.setString(10, u.getUsuLogin());
            ps.setString(11, u.getUsuContrasena());
            ps.setBoolean(12, u.isUsuEstado());
            ps.setInt(13, u.getUsuId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminarUsuario (Usuario u){
        String sql = "DELETE FROM usuario WHERE usuario_id = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, u.getUsuId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Usuario> buscarUsuario (String usuNombre){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE usuario_nombre = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, usuNombre);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Usuario u = new Usuario();
                    u.setUsuId(rs.getInt("usuario_id"));
                    u.setUsuCodigo(rs.getString("usuario_codigo"));
                    u.setUsuNombre(rs.getString("usuario_nombre"));
                    u.setUsuApellido(rs.getString("usuario_apellido"));
                    u.setUsuFechaNac(rs.getDate("usuario_fechaNacimiento").toLocalDate());
                    u.setUsuProfesion(rs.getString("usuario_profesion"));
                    u.setUsuCI(rs.getString("usuario_ci"));
                    u.setUsuCelular(rs.getInt("usuario_celular"));
                    u.setUsuGenero(rs.getString("usuario_genero"));
                    u.setUsuCargo(rs.getString("usuario_cargo"));
                    u.setUsuLogin(rs.getString("usuario_login"));
                    u.setUsuContrasena(rs.getString("usuario_constrasena"));
                    u.setUsuEstado(rs.getBoolean("usuario_estado"));
                    lista.add(u);
                }
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Usuario obtenerUsuarioPorId(int usuId){
        String sql = "SELECT * FROM usuario WHERE usuario_id = ?";
        Usuario usuario = null;

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, usuId);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    usuario = new Usuario();
                    usuario.setUsuId(rs.getInt("usuario_id"));
                    usuario.setUsuCodigo(rs.getString("usuario_codigo"));
                    usuario.setUsuNombre(rs.getString("usuario_nombre"));
                    usuario.setUsuApellido(rs.getString("usuario_apellido"));
                    usuario.setUsuFechaNac(rs.getDate("usuario_fechaNacimiento").toLocalDate());
                    usuario.setUsuProfesion(rs.getString("usuario_profesion"));
                    usuario.setUsuCI(rs.getString("usuario_ci"));
                    usuario.setUsuCelular(rs.getInt("usuario_celular"));
                    usuario.setUsuGenero(rs.getString("usuario_genero"));
                    usuario.setUsuCargo(rs.getString("usuario_cargo"));
                    usuario.setUsuLogin(rs.getString("usuario_login"));
                    usuario.setUsuContrasena(rs.getString("usuario_constrasena"));
                    usuario.setUsuEstado(rs.getBoolean("usuario_estado"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

}