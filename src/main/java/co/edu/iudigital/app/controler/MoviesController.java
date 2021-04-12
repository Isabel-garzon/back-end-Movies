package co.edu.iudigital.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Movies;
import co.edu.iudigital.app.service.iface.MoviesService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")

public class MoviesController {
	
	@Autowired
	private MoviesService moviesService;
	
	@GetMapping
	public List<Movies> getAll(){
		return moviesService.getAll();		
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody Movies movies) {
		moviesService.create(movies);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void edit(@RequestBody Movies movies, @PathVariable int id) {
		moviesService.edit(movies,  id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		moviesService.delete(id);
	}
	@PutMapping("/rate/{id}")
	public void rate(@RequestBody Movies movies, @PathVariable int id) {
		moviesService.rate(movies, id);
	}
}
