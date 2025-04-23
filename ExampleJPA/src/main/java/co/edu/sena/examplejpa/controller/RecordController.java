/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Record
 */
public class RecordController implements IRecordController {

    
    @Override
    public void insert(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        } 
        
        if(record.getDateRecord() == null)
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if(record.getStartTime() == null)
        {
            throw new Exception("La hora de salida es obligatoria");
        }
        
        if(record.getEndTime() == null)
        {
            throw new Exception("La hora de salida es obligatoria");
        }
        
        //FK
        if(record.getEmployeeId()== null)
        {
            throw new Exception("El documento empleado es obligatorio");
        }
        
        if(record.getKeyId()== null)
        {
            throw new Exception("El id de la llave es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estado es obligatoria");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        } 
        
        if(record.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if(record.getDateRecord() == null)
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if(record.getStartTime() == null)
        {
            throw new Exception("La hora de salida es obligatoria");
        }
        
        //FK
        if(record.getEmployeeId() == null)
        {
            throw new Exception("El documento empleado es obligatorio");
        }
        
        if(record.getKeyId()== null)
        {
            throw new Exception("El id de la llave es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estdo es obligatoria");
        }
        
        //Consultar si existe en la bd
        Record recordExists = DAOFactory.getRecordDAO().findById(record.getId());
        if (recordExists == null) 
        {
            throw new Exception("El registro no existe");
        }
        
        //Merge
        recordExists.setDateRecord(record.getDateRecord());
        recordExists.setEmployeeId(record.getEmployeeId());
        recordExists.setEndTime(record.getEndTime());
        recordExists.setKeyId(record.getKeyId());
        recordExists.setStartTime(record.getStartTime());
        recordExists.setStatus(record.getStatus());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if (recordExists == null) 
        {
            throw new Exception("El registro no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Record> findAll() throws Exception {
       return DAOFactory.getRecordDAO().findAll();
    }

    @Override
    public Record findById(Integer id) throws Exception {
       if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
       
       return DAOFactory.getRecordDAO().findById(id);
    }
    
}
