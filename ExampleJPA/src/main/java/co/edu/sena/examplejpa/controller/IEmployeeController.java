/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Lina Vanessa Salcedo
 * Objetivo: Interface para el modelo Employee
 */
public interface IEmployeeController {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete(Long document) throws Exception;
    public List<Employee> findAll() throws Exception;
    public Employee findById(Long document) throws Exception;
}
