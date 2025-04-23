/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Employee
 */
public class EmployeeController implements IEmployeeController {

    @Override
    public void insert(Employee employee) throws Exception {
        if(employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getDireccion()))
        {
            throw new Exception("La direccion es obligatoria");
        }
        
        if("".equals(employee.getTelefono()))
        {
            throw new Exception("El telefono es obligatoria");
        }
        
        //FK
        if(employee.getTypeId() == null)
        {
            throw new Exception("El tipo de empleado es obligatoria");
        }
        
        //La PK no es autoincremental, se debe validar existencia el empleado
        
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists != null) 
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().insert(employee);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Employee employee) throws Exception {
        if(employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getDireccion()))
        {
            throw new Exception("La direccion es obligatoria");
        }
        
        if("".equals(employee.getTelefono()))
        {
            throw new Exception("El telefono es obligatoria");
        }
        
        //FK
        if(employee.getTypeId()== null)
        {
            throw new Exception("El tipo de empleado es obligatoria");
        }

        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists == null) 
        {
            throw new Exception("No existe el empleado");
        }
        
        //Merge
        employeeExists.setDireccion(employee.getDireccion());
        employeeExists.setFullname(employee.getFullname());
        employeeExists.setTelefono(employee.getTelefono());
        employeeExists.setTypeId(employee.getTypeId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().update(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
        
    }

    @Override
    public void delete(Long document) throws Exception {
        if(document== 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(document);
        if (employeeExists == null) 
        {
            throw new Exception("No existe el empleado");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().delete(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return DAOFactory.getEmployeeDAO().findAll();
    }

    @Override
    public Employee findById(Long document) throws Exception {
        if(document== 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        return DAOFactory.getEmployeeDAO().findById(document);
    }
    
    
}
