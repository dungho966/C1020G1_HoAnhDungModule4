package com.example.repository.impl;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> showAllCustomer() {
        Query typedQuery =
                BaseRepository.entityManager.createNativeQuery("select * from customer", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public void deleteCustomer(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findCustomerById( id ));
        entityTransaction.commit();
    }

    @Override
    public void editCustomer(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(customer);
        entityTransaction.commit();
    }

    @Override
    public void createCustomer(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return BaseRepository.entityManager.find( Customer.class, id );
    }
}