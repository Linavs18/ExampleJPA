/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Key
 */
public class KeyRoomController implements IKeyRoomController {
    
    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null)
        {
             throw new Exception("La llave es nula");
        }
        
        if("".equals(keyRoom.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(keyRoom.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(keyRoom.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta, debe ser minimo 1");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(KeyRoom key) throws Exception {
        if(key == null)
        {
             throw new Exception("La llave es nula");
        }
        
        if (key.getId() == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta, debe ser minimo 1");
        }
        
        //Consultar si existe en la bd
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(key.getId());
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //merge
        keyExists.setCount(key.getCount());
        keyExists.setName(key.getName());
        keyExists.setObservation(key.getObservation());
        keyExists.setRoom(key.getRoom());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
         if (id == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
        //Consultar si existe en la bd
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(id);
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().findAll();
    }

    @Override
    public KeyRoom findById(Integer id) throws Exception {
         if (id == 0) 
        {
            throw new Exception("El id es obligatorio");
        }
        
         return DAOFactory.getKeyRoomDAO().findById(id);
    }
    
}
