package pe.com.retail.customer.infrastructure;

import org.springframework.stereotype.Repository;

import pe.com.retail.customer.domain.entity.ParameterEntity;
import pe.com.retail.customer.domain.repository.ParameterRepository;
import pe.com.retail.customer.infrastructure.repository.ParameterJpaRepository;

@Repository
public class ParameterRepositoryImpl implements ParameterRepository {

	private final ParameterJpaRepository parameterJpaRepository;

	public ParameterRepositoryImpl(ParameterJpaRepository parameterJpaRepository) {
		this.parameterJpaRepository = parameterJpaRepository;
	}

	public ParameterEntity findParameter(String nameParameter) {
		return parameterJpaRepository.findByNameParameter(nameParameter);
	}
}
