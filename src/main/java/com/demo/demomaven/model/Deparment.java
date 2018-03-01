/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author E301
 */
@Entity
@Table(name = "deparment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deparment.findAll", query = "SELECT d FROM Deparment d"),
    @NamedQuery(name = "Deparment.findByIddeparment", query = "SELECT d FROM Deparment d WHERE d.iddeparment = :iddeparment"),
    @NamedQuery(name = "Deparment.findByName", query = "SELECT d FROM Deparment d WHERE d.name = :name"),
    @NamedQuery(name = "Deparment.findByLocation", query = "SELECT d FROM Deparment d WHERE d.location = :location")})
public class Deparment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeparment")
    private Integer iddeparment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "iddept")
    private List<Employee> employeeList;

    public Deparment() {
    }

    public Deparment(Integer iddeparment) {
        this.iddeparment = iddeparment;
    }

    public Deparment(Integer iddeparment, String name, String location) {
        this.iddeparment = iddeparment;
        this.name = name;
        this.location = location;
    }

    public Integer getIddeparment() {
        return iddeparment;
    }

    public void setIddeparment(Integer iddeparment) {
        this.iddeparment = iddeparment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeparment != null ? iddeparment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deparment)) {
            return false;
        }
        Deparment other = (Deparment) object;
        if ((this.iddeparment == null && other.iddeparment != null) || (this.iddeparment != null && !this.iddeparment.equals(other.iddeparment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.demomaven.model.Deparment[ iddeparment=" + iddeparment + " ]";
    }
    
}
