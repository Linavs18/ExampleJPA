/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 * fecha: 08/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Interface para DAO de tipo de empleado
 */
public interface IEmployeeTypeDAO {
    public void insert(EmployeeType employeeType) throws Exception;
    public void update(EmployeeType employeeType) throws Exception;
    public void delete(EmployeeType employeeType) throws Exception;
    public EmployeeType findById(Integer id) throws Exception;
    public List<EmployeeType> findAll() throws Exception;
}
