/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Record;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IRecordDAO {
    public void insert(Record record) throws Exception;
    public void update(Record record) throws Exception;
    public void delete(Record record) throws Exception;
    public Record findById(Integer id) throws Exception;
    public List<Record> findAll() throws Exception;
}
