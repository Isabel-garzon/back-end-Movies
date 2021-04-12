package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.model.entity.Movies;

public interface MoviesService {
	
	/**
	 * Obtener todas las peliculas
	 * @return
	 */
	
public List<Movies> getAll();


/**
 * crear una pelicula
 * @param movies
 */

public void create(Movies movies);


/**
 * edita una pelicula por su Id
 * @param movies
 * @param moviedId
 */

public void edit(Movies movies, int moviedId);

/**
 * Borra una pelicula por su Id
 * @param moviedId
 */

public void delete(int moviedId);


/**
 * Calificar una pelicula
 * @param movies
 * @param moviedId
 */

public void rate(Movies movies, int moviedId);



}
