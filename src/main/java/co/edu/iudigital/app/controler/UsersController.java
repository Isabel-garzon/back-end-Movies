package co.edu.iudigital.app.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Users;
import co.edu.iudigital.app.service.iface.UsersService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")

public class UsersController {
    @Autowired
    private UsersService usersService;
    
    @PostMapping("/login")
    public Users login(@RequestBody Users users) throws Exception{
    	return usersService.login(users);
    }

}
