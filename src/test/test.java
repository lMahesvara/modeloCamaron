/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import entidades.Cliente;
import entidades.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cliente cliente = new Cliente("ea", "dp");
        Pedido p = new Pedido();
        p.setPrecioTotal(222);

        
        
        
        EntityManager em;
        //Obtiene acceso alemFactory a partir de la persistence unit utilizada
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("camaronPU");
//        Cache cache = emf.getCache();
//        cache.evictAll();
        // Creamos una em(bd) para realizar operaciones con la bd
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
        Cliente c = em.find(Cliente.class, 1);
        p.setCliente(c);
        
        em.persist(p);
        em.getTransaction().commit();
        //Publicacion p = em.find(Publicacion.class, )
        em.close();
    }
    
}
