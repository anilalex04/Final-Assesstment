package com.te.carapplication.dao;

import org.springframework.data.repository.CrudRepository;
import com.te.carapplication.dto.CarApplicationInfo;

public interface CarDao extends CrudRepository<CarApplicationInfo, Integer> {

	public CarApplicationInfo findByCarId(int carId);
}
