package co.edu.iudigital.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.Movies;
import co.edu.iudigital.app.model.repository.GendersRepository;
import co.edu.iudigital.app.model.repository.MoviesRepository;
import co.edu.iudigital.app.service.iface.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService{

	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private GendersRepository gendersRepository;
	
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
		if(existsGenders) {
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
			existsMovies.get().setImage(movies.getImage());
			existsMovies.get().setActors(movies.getActors());
			existsMovies.get().setRelease(movies.getRelease());
			existsMovies.get().setRating(movies.getRating());
			
			boolean existsGenders = gendersRepository
					.existsById(movies.getGenderId().getId());
			if(existsGenders) {
				existsMovies.get().setGenderId(movies.getGenderId());
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
		if(existsMovies.isPresent()) {
			existsMovies.get()
			.setRating(existsMovies.get().getRating() + movies.getRating());
			moviesRepository.save(existsMovies.get());
		}
	}

}