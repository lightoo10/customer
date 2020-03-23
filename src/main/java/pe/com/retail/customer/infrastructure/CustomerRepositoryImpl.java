package pe.com.retail.customer.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.retail.customer.domain.entity.CustomerEntity;
import pe.com.retail.customer.domain.repository.CustomerRepository;
import pe.com.retail.customer.infrastructure.repository.CustomerJpaRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private final CustomerJpaRepository customerJpaRepository;

	public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository = customerJpaRepository;
	}

	public List<CustomerEntity> findCustomerByName(String name) {
		return customerJpaRepository.findByName(name);
	}

	public List<CustomerEntity> findCustomers() {
		return customerJpaRepository.findAll();
	}

	public CustomerEntity registerCustomer(CustomerEntity customerEntity) {
		return customerJpaRepository.save(customerEntity);
	}

	public void deleteCustomer(String documentoIdentidad) {
		customerJpaRepository.deleteById(documentoIdentidad);
	}
}
