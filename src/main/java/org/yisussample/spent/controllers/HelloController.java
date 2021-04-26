package org.yisussample.spent.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yisussample.spent.model.Customer;
import org.yisussample.spent.repository.CustomerRepository;

@RestController("/")
@Slf4j
public class HelloController {

  @Autowired private CustomerRepository repository;

  @RequestMapping("/")
  public String main() {
    return "Greetings from Spring Boot! Main!";
  }

  @RequestMapping("/index")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/map")
  public Map<String, Object> map() {
    return Stream.of(
            new String[][] {
              {"Hello", "World"},
              {"John", "Doe"},
            })
        .collect(Collectors.toMap(data -> data[0], data -> data[1]));
  }

  @RequestMapping(value = "/customer", method = RequestMethod.POST)
  public Customer save(@RequestBody Customer customer) {

    log.info(" CUSTOMER {}", customer);

    return repository.save(customer);
  }

  @RequestMapping(value = "/customer", method = RequestMethod.GET)
  public List<Customer> getAll() {
    return repository.findAll();
  }

  @RequestMapping(value = "/customer/{name}", method = RequestMethod.GET)
  public List<Customer> getByNames(@PathVariable("name") String name) {
    return repository.findByFirstNameOrLastNameContainingIgnoreCase(name, name);
  }

  @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") String id) {
    repository.delete(Customer.builder().id(id).build());
  }

  @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
  public void delete() {
    repository.deleteAll();
  }
}
