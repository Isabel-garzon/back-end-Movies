package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.Genders;
import co.edu.iudigital.app.model.repository.GendersRepository;
import co.edu.iudigital.app.service.iface.GendersService;

@Service
public class GendersServiceImpl implements GendersService{

	@Autowired
	private GendersRepository genderRepository; 
	
	@Override
	public List<Genders> getAll() {
		List<Genders> gender = new ArrayList<>();
		gender =(List<Genders>) genderRepository.findAll();
		return gender;
	}

}
