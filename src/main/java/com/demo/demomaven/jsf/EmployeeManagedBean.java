/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.jsf;

import com.demo.demomaven.model.Employee;
import com.demo.demomaven.ejb.EmployeeSessionBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author docente
 */
@Named(value = "employeeManagedBean")
@ViewScoped
public class EmployeeManagedBean implements Serializable {

    @EJB(name = "employeeEjb")
    private EmployeeSessionBean sessionBean;
    private Employee employee = new Employee();

    public EmployeeSessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(EmployeeSessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeManagedBean() {
    }

    public void save() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.getSessionBean().save(employee);
        context.addMessage(null, new FacesMessage("Registro OK"));
    }
}
