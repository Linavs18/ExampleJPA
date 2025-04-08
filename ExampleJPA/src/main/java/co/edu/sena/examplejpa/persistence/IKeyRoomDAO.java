/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IKeyRoomDAO {
    public void insert(KeyRoom keyRoom) throws Exception;
    public void update(KeyRoom keyRoom) throws Exception;
    public void delete(KeyRoom keyRoom) throws Exception;
    public KeyRoom findById(Integer id) throws Exception;
    public List<KeyRoom> findAll() throws Exception;
}
