/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

 package dao;

import bean.Phspclientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author pedro
 */
public class PhspClientesDAO extends AbstractDAO{
    
    

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
        Criteria criteria = session.createCriteria(Phspclientes.class);
        criteria.add(Restrictions.eq("phspIdClientes", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
     public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspclientes.class);
        criteria.add(Restrictions.like("phspNome", "%" +nome+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     
     public Object listID(int ID) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspclientes.class);
        criteria.add(Restrictions.like("phspIdClientes", ID));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     
      public Object listIDNome(int ID, String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspclientes.class);
        criteria.add(Restrictions.like("phspIdClientes", ID));
        criteria.add(Restrictions.ge("phspNome", nome));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspclientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        PhspClientesDAO    phspClientesDAO = new PhspClientesDAO();
        phspClientesDAO.listAll();
    }
    
    public boolean existeId(int id) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Phspclientes.class);
    criteria.add(Restrictions.eq("phspIdClientes", id));
    List lista = criteria.list();
    session.getTransaction().commit();

    return !lista.isEmpty();
    }
}
