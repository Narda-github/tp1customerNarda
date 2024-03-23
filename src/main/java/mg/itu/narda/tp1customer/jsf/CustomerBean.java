/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tp1customer.jsf;

import mg.itu.narda.tp1customer.entity.Customer;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import mg.itu.narda.tp1customer.service.CustomerManager;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    @Inject
    private CustomerManager customerManager;

    private List<Customer> customerList;

    private List<Customer> filteredCustomers;
    private List<String> states;

    public CustomerBean() {
    }

    public void setFilteredCustomers(List<Customer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }

    public List<Customer> getFilteredCustomers() {
        return filteredCustomers;
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    public List<String> getStates() {
        if (states == null) {
            states = customerManager.getStates();
        }
        return states;
    }
}
