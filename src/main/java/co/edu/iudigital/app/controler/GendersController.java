package co.edu.iudigital.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Genders;
import co.edu.iudigital.app.service.iface.GendersService;

@RestController
@RequestMapping("/genders")
@CrossOrigin("*")
public class GendersController {
	//Inyección de dependencias desde el service
	@Autowired
	private GendersService gendersService;
	
	@GetMapping
	public List<Genders> getAll(){
		return gendersService.getAll();
		
	}
	

}
