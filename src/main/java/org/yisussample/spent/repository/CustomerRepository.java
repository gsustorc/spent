package org.yisussample.spent.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.yisussample.spent.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  Customer findByFirstName(String firstName);

  List<Customer> findByLastName(String lastName);

  List<Customer> findByFirstNameOrLastNameContainingIgnoreCase(String name1, String name2);
}
