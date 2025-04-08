/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 08/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Implementar DAO para modelo tipo de empleado
 */
public class EmployeeTypeDAO implements IEmployeeTypeDAO{

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public EmployeeType findById(Integer id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(EmployeeType.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("EmployeeType.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
