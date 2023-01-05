package com.escuela.data;


import com.escuela.domain.TUsuario;

public interface UsuarioDao {

    //********************************* REGISTER USER
    public void addUser(TUsuario user);

    //******************************** FIND USER
    public TUsuario findUser(TUsuario user) ;
    public TUsuario findUser(int id);
    public TUsuario findUser(String username , String password);
    public TUsuario findUser(String username); // USERNAME OR EMAIL

    //***********************************UPDATE USER FOR CHANGE OF PASSWORD OR VERIFI ACCOUNT
    public void updateUser(TUsuario user);

    //*********************************** DELETE USER (MAYBE WILL NOT BE IMPLEMENTED)
    public void deleteUser(TUsuario user);



}
