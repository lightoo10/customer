package pe.com.retail.customer.domain.repository;

import pe.com.retail.customer.domain.entity.ParameterEntity;

public interface ParameterRepository {

	ParameterEntity findParameter(String nameParameter);
}
