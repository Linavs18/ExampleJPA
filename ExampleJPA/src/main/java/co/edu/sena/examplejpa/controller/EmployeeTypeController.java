/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de EmployeeType
 */
public class EmployeeTypeController implements IEmployeeTypeController{

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
            throw new Exception("El tipo de empleado es nulo");
        }
        
        if("".equals(employeeType.getDescript()))
        {
             throw new Exception("La decripcion es obligatoria");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
            throw new Exception("El tipo de empleado es nulo");
        }
        
        if(employeeType.getId() == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        if("".equals(employeeType.getDescript()))
        {
             throw new Exception("La decripcion es obligatoria");
        }
        //Consultar si existe en la bd
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(employeeType.getId());
        if(employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //merge: todos los campos menos la PK
        employeeTypeExists.setDescript(employeeType.getDescript());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        //Consultar si existe en la bd
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(id);
        if(employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return DAOFactory.getEmployeeTypeDAO().findAll();
    }

    @Override
    public EmployeeType findById(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        return DAOFactory.getEmployeeTypeDAO().findById(id);
    }
    
}
