package com.te.carapplication.carService;

import java.util.List;

import com.te.carapplication.dto.CarApplicationInfo;

public interface CarService {

	CarApplicationInfo addData(CarApplicationInfo applicationInfo);
	
	CarApplicationInfo modify(int carId,CarApplicationInfo applicationInfo);

	CarApplicationInfo search(int carId);
	
	void delete(int carId);
	
	List<CarApplicationInfo> allDetails();

}
