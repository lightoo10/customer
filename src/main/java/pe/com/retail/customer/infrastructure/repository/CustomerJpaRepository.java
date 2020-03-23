package pe.com.retail.customer.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.retail.customer.domain.entity.CustomerEntity;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, String> {

	List<CustomerEntity> findByName(String name);

}
