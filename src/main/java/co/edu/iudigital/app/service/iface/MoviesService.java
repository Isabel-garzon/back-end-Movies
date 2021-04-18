package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.model.entity.Movies;

public interface MoviesService {
	/**
	 * Obtener todas las películas
	 * @return
	 */
	public List<Movies> getAll();
	/**
	 * Crear una película
	 * @param movie
	 */
	public void create(Movies movies);
	/**
	 * Edita una película por su Id
	 * @param movie
	 * @param movieId
	 */
	public void edit(Movies movies, int movieId);
	/**
	 * Borra una película por su Id
	 * @param movieId
	 */
	public void delete(int movieId);
	/**
	 * Califica una película
	 * @param movie
	 * @param movieId
	 */
	public void rate(Movies movies, int movieId);
}