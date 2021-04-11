package co.edu.iudigital.app.service.iface;

import co.edu.iudigital.app.model.entity.Users;

public interface UsersService {
	
	/**
	 * Crear nuevo usuario
	 * @param users
	 */	
	public void create(Users users);	
	/**
	 * Loguea un usuario
	 * @param Users
	 * @return
	 * @throws Exception
	 */
    public Users login(Users Users) throws Exception;
    
}
