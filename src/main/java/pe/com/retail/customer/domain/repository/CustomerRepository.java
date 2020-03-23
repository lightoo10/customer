package pe.com.retail.customer.domain.repository;

import java.util.List;

import pe.com.retail.customer.domain.entity.CustomerEntity;

public interface CustomerRepository {

	List<CustomerEntity> findCustomers();

	List<CustomerEntity> findCustomerByName(String name);

	CustomerEntity registerCustomer(CustomerEntity clientEntity);

	void deleteCustomer(String documentoIdentidad);
}
