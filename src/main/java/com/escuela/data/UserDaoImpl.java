package com.escuela.data;

import com.escuela.domain.TUsuario;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDaoImpl implements UsuarioDao {
    @PersistenceContext(unitName = "EscuelaPU")
    EntityManager em;

    @Override
    public void addUser(TUsuario user) {
        em.persist(user);
    }

    @Override
    public TUsuario findUser(TUsuario user) {
        Query query = em.createNamedQuery("User.findUser" , TUsuario.class);
        query.setParameter("username" , user.getUsername());
        query.setParameter("password" , user.getPassword());
        TUsuario us = null;
        try {
            us =  (TUsuario) query.getSingleResult();
            System.out.println(us.toString());
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        return us;
    }

    @Override
    public void updateUser(TUsuario user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(TUsuario user) {
        em.remove(em.merge(user));
    }

    //****************************** FUNCTION PENDING IMPLEMENT
    @Override
    public TUsuario findUser(int id) {

        return em.find(TUsuario.class , id );
    }

    @Override
    public TUsuario findUser(String username, String password) {
        return null;
    }

    @Override
    public TUsuario findUser(String username) {
        return null;
    }

}
