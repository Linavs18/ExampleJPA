/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "key_room")
@NamedQueries({
    @NamedQuery(name = "KeyRoom.findAll", query = "SELECT k FROM KeyRoom k"),
    @NamedQuery(name = "KeyRoom.findById", query = "SELECT k FROM KeyRoom k WHERE k.id = :id"),
    @NamedQuery(name = "KeyRoom.findByName", query = "SELECT k FROM KeyRoom k WHERE k.name = :name"),
    @NamedQuery(name = "KeyRoom.findByRoom", query = "SELECT k FROM KeyRoom k WHERE k.room = :room"),
    @NamedQuery(name = "KeyRoom.findByCount", query = "SELECT k FROM KeyRoom k WHERE k.count = :count"),
    @NamedQuery(name = "KeyRoom.findByObservation", query = "SELECT k FROM KeyRoom k WHERE k.observation = :observation")})
public class KeyRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "room")
    private String room;
    @Basic(optional = false)
    @Column(name = "count")
    private int count;
    @Column(name = "observation")
    private String observation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keyId")
    private Collection<Record> recordCollection;

    public KeyRoom() {
    }

    public KeyRoom(Integer id) {
        this.id = id;
    }

    public KeyRoom(Integer id, String name, String room, int count) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Collection<Record> getRecordCollection() {
        return recordCollection;
    }

    public void setRecordCollection(Collection<Record> recordCollection) {
        this.recordCollection = recordCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeyRoom)) {
            return false;
        }
        KeyRoom other = (KeyRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.examplejpa.model.KeyRoom[ id=" + id + " ]";
    }
    
}
