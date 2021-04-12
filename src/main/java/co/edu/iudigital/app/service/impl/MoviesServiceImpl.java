package co.edu.iudigital.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

import co.edu.iudigital.app.model.entity.Genders;
import co.edu.iudigital.app.model.entity.Movies;
import co.edu.iudigital.app.model.repository.MoviesRepository;
import co.edu.iudigital.app.service.iface.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService{
	
	@Autowired
	private MoviesRepository moviesRepository;
	@Autowired
	private Genders gendersRepository;

	@Override
	public List<Movies> getAll() {
		List<Movies> movies = new ArrayList<>();
		movies = (List<Movies>) moviesRepository.findAll();
		return movies;
	}

	@Override
	public void create(Movies movies) {
		boolean existsGenders = gendersRepository
				.existsById(movies.getGenderId().getId());
		if (existsGenders) {
			movies.setCreateAt(LocalDateTime.now());
			
			moviesRepository.save(movies);
		}
		
	}

	@Override
	public void edit(Movies movies, int movieId) {
	Optional<Movies> existsMovies = moviesRepository.findById(movieId);
	if(existsMovies.isPresent()) {
		existsMovies.get().setName(movies.getName());
		existsMovies.get().setDescripcion(movies.getDescripcion());
		existsMovies.get().setActor(movies.getActors());
		existsMovies.get().setImagen(movies.getImage());
		existsMovies.get().setRating(movies.getRating());
		existsMovies.get().setRelease(movies.getRelease());
		boolean existsGenders = gendersRepository.existsById(movies.getGenderId().getId());
		if (existsGenders) {
			existsMovies.get().setGenderId(movies.getId());			
		}
		moviesRepository.save(existsMovies.get());		
	}
			
}

	@Override
	public void delete(int movieId) {
		Optional<Movies> existsMovies = moviesRepository.findById(movieId);
		if(existsMovies.isPresent()) {
			moviesRepository.delete(existsMovies.get());
			
		}	
		
	}

	@Override
	public void rate(Movies movies, int movieId) {
		Optional<Movies> existsMovies = moviesRepository.findById(movieId);
		if (existsMovies.isPresent()) {
			existsMovies.get().setRating(existsMovies.get().getRating + movies.getRating());
			moviesRepository.save(existsMovies.get());
		}
		
		
	}

}
