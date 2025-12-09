/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

 package dao;

import bean.Phspvendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author pedro
 */
public class PhspVendasDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspvendas.class);
        criteria.add(Restrictions.eq("phspIdVendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
     public Object listID(int ID) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspvendas.class);
        criteria.add(Restrictions.like("phspIdVendas", ID));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     
      public Object listTotal(double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspvendas.class);
        criteria.add(Restrictions.ge("phspTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        }
      
       public Object listIDTotal(int ID, double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspvendas.class);
        criteria.add(Restrictions.like("phspIdVendas", ID));
        criteria.add(Restrictions.ge("phspPreco", total));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspvendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        PhspVendasDAO    phspVendasDAO = new PhspVendasDAO();
        phspVendasDAO.listAll();
    }
    
     public boolean existeId(int id) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Phspvendas.class);
    criteria.add(Restrictions.eq("phspIdVendas", id));
    List lista = criteria.list();
    session.getTransaction().commit();

    return !lista.isEmpty();
    }
}
