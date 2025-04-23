/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Lina Vanessa Salcedo
 * Objetivo: Interface para el modelo EmployeeType
 */
public interface IEmployeeTypeController {
    public void insert(EmployeeType employeeType) throws Exception;
    public void update(EmployeeType employeeType) throws Exception;
    public void delete(Integer id) throws Exception;
    public List<EmployeeType> findAll() throws Exception;
    public EmployeeType findById(Integer id) throws Exception;
}
