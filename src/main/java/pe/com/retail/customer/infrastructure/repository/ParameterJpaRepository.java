package pe.com.retail.customer.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.retail.customer.domain.entity.ParameterEntity;

public interface ParameterJpaRepository extends JpaRepository<ParameterEntity, String> {

	ParameterEntity findByNameParameter(String nameParameter);

}
