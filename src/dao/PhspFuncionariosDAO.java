/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Phspfuncionarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author pedro
 */
public class PhspFuncionariosDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(Phspfuncionarios.class);
        criteria.add(Restrictions.eq("phspIdFuncionario", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Phspfuncionarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        PhspFuncionariosDAO    phspFuncionariosDAO = new PhspFuncionariosDAO();
        phspFuncionariosDAO.listAll();
    }
    
    public boolean existeId(int id) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Phspfuncionarios.class);
    criteria.add(Restrictions.eq("phspIdFuncionario", id));
    List lista = criteria.list();
    session.getTransaction().commit();

    return !lista.isEmpty();
    }
}
