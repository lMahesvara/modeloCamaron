/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import interfaces.IConexionBD;
import interfaces.IModeloCliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class ModeloCliente implements IModeloCliente{
    private final IConexionBD conexionBD;

    public ModeloCliente(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Cliente consultar(Integer idCliente) {
       EntityManager em = this.conexionBD.crearConexion();
        try {
            Cliente c = em.find(Cliente.class, idCliente);
            System.out.println(c);
            return c;
        } catch (IllegalStateException e) {
            System.err.println("No se pudo consultar el pedido" + idCliente);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cliente> consultar() {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            Query query = em.createQuery("SELECT e FROM Cliente e");
            List<Cliente> clientes = new ArrayList();
            return clientes =query.getResultList();
        } catch (IllegalStateException e) {
            System.err.println("No se pudieron consultar los pedidos");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente eliminar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
