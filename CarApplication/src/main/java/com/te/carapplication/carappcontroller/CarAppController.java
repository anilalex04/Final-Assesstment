package com.te.carapplication.carappcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.carapplication.carService.CarService;
import com.te.carapplication.dto.CarApplicationInfo;

@RestController
public class CarAppController {
	@Autowired
	private CarService carService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addData(@RequestBody CarApplicationInfo applicationInfo){
		try {
			carService.addData(applicationInfo);
			return new ResponseEntity<String>("Data addes successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify/{carId}")
	public ResponseEntity<?> modifyData(@RequestBody CarApplicationInfo applicationInfo, @PathVariable int carId){
		try {
			carService.modify(carId,applicationInfo);
			return new ResponseEntity<String>("Data updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/search/{carId}")
	public ResponseEntity<?> search(@PathVariable int carId){
		CarApplicationInfo applicationInfo = carService.search(carId);
		if(applicationInfo!=null) {
			return new ResponseEntity<CarApplicationInfo>(applicationInfo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("data not found for id:" + carId, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{carId}")
	public ResponseEntity<?> delete(@PathVariable int carId){
		try {
			carService.delete(carId);
			return new ResponseEntity<String>("Data deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Data Not Foung!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/details")
	public List<CarApplicationInfo> allDetails(){
		List<CarApplicationInfo> carApplicationInfos = carService.allDetails();
		return carApplicationInfos;
		
	}
	
}
	
