/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Lista;
import modelo.Producto;

/**
 *
 * @author Breyner
 */
public class OperacionesTabla {
    private Conexion conexion = new Conexion();

    // -- REQUISITO A: CATEGORIAS --
    public void insertarCategoria(String nombre) throws SQLException {
        String sql = "INSERT INTO tblcategorias (denominacion) VALUES (?)";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        }
    }

    public List<Categoria> obtenerCategorias() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT codigocategoria, denominacion FROM tblcategorias";
        try (Connection con = conexion.getConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Categoria(rs.getInt(1), rs.getString(2)));
            }
        }
        return lista;
    }

    // -- REQUISITO B: PRODUCTOS (CATALOGO) --
    public void insertarProducto(String nombre, int idCat) throws SQLException {
        String sql = "INSERT INTO tblproductos (denominacion, codigocategoria) VALUES (?, ?)";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, idCat);
            ps.executeUpdate();
        }
    }

    public List<Producto> obtenerProductosPorCategoria(int idCat) throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT codigoproducto, denominacion, codigocategoria FROM tblproductos WHERE codigocategoria = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCat);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
            }
        }
        return lista;
    }

    // -- REQUISITO C: LISTAS DE COMPRA --
    public void insertarLista(String nombre) throws SQLException {
        String sql = "INSERT INTO tbllistas (denominacion) VALUES (?)";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        }
    }

    public List<Lista> obtenerListas() throws SQLException {
        List<Lista> listas = new ArrayList<>();
        String sql = "SELECT codigolista, denominacion FROM tbllistas";
        try (Connection con = conexion.getConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                listas.add(new Lista(rs.getInt(1), rs.getString(2)));
            }
        }
        return listas;
    }

    public void agregarProductoLista(int idLista, int idProd, int cantidad) throws SQLException {
        String sql = "INSERT INTO tbl_lista_producto (codigoLista, codigoProducto, cantidad) VALUES (?, ?, ?)";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLista);
            ps.setInt(2, idProd);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
        }
    }

    public void eliminarProductoLista(int idLista, int idProd) throws SQLException {
        String sql = "DELETE FROM tbl_lista_producto WHERE codigoLista = ? AND codigoProducto = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLista);
            ps.setInt(2, idProd);
            ps.executeUpdate();
        }
    }

    // Retorna Objeto con: ID Producto, Nombre Producto, Cantidad
    public List<Object[]> obtenerProductosDeLista(int idLista) throws SQLException {
        List<Object[]> resultados = new ArrayList<>();
        String sql = "SELECT p.codigoproducto, p.denominacion, lp.cantidad " +
                     "FROM tbl_lista_producto lp " +
                     "JOIN tblproductos p ON lp.codigoProducto = p.codigoproducto " +
                     "WHERE lp.codigoLista = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLista);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resultados.add(new Object[]{rs.getInt(1), rs.getString(2), rs.getInt(3)});
                }
            }
        }
        return resultados;
    }
}
