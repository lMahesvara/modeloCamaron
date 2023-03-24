/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import interfaces.IConexionBD;
import interfaces.IModeloProducto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class ModeloProducto implements IModeloProducto{
    private final IConexionBD conexionBD;

    public ModeloProducto(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Producto consultar(Integer idProducto) {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            Producto p = em.find(Producto.class, idProducto);
            System.out.println(p);
            return p;
        } catch (IllegalStateException e) {
            System.err.println("No se pudo consultar el pedido" + idProducto);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> consultar() {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            Query query = em.createQuery("SELECT e FROM Producto e");
            List<Producto> prod = new ArrayList();
            return prod =query.getResultList();
        } catch (IllegalStateException e) {
            System.err.println("No se pudieron consultar los pedidos");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Producto eliminar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto registrar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto actualizar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
