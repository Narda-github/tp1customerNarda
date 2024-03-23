package mg.itu.narda.tp1customer.service;

import jakarta.annotation.PostConstruct;
import mg.itu.narda.tp1customer.entity.Customer;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;
import java.util.Arrays;

/**
 *
 * Façade pour gérer les Customers.
 *
 * @author Narda <mg.itu.narda>
 */
@RequestScoped
public class CustomerManager {

    private String[] states;

    @PostConstruct
    public void init() {
        states = new String[]{"FL", "GA", "TX", "CA", "NY", "MI"};

    }
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public List<String> getStates() {
        return Arrays.asList(states);
    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
}
