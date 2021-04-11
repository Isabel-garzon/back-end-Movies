package co.edu.iudigital.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.app.model.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
public Users findByEmailAndPassword(String email, String password);
}
