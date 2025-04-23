/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Lina Vanessa Salcedo
 * Objetivo: Interface para el modelo Record
 */
public interface IRecordController {
    public void insert (Record record) throws Exception;
    public void update (Record record) throws Exception;
    public void delete (Integer id) throws Exception;
    public List<Record> findAll() throws Exception;
    public Record findById(Integer id) throws Exception;
}
