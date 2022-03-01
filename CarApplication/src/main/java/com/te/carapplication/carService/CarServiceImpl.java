package com.te.carapplication.carService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.carapplication.dao.CarDao;
import com.te.carapplication.dao.UserDao;
import com.te.carapplication.dto.CarApplicationInfo;
import com.te.carapplication.dto.MyUserApp;
import com.te.carapplication.dto.UserApp;
@Service
public class CarServiceImpl implements CarService, UserDetailsService{
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private UserDao userDao;


	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp userApp = userDao.findByUsername(username);
		if(userApp!= null) {
			return new MyUserApp(userApp);
		}
		throw new UsernameNotFoundException("Could not find User") ;
	}



	@Override
	public List<CarApplicationInfo> allDetails() {
		return (List<CarApplicationInfo>) carDao.findAll();
	}



	@Override
	public CarApplicationInfo addData(CarApplicationInfo applicationInfo) {
		return carDao.save(applicationInfo);
	}



	@Override
	public CarApplicationInfo modify(int carId,CarApplicationInfo applicationInfo) {
		return carDao.save(applicationInfo);
	}



	@Override
	public CarApplicationInfo search(int carId) {
		return carDao.findByCarId(carId);
	}



	@Override
	public void delete(int carId) {
		CarApplicationInfo applicationInfo = carDao.findByCarId(carId);
		carDao.delete(applicationInfo);
	}

}
