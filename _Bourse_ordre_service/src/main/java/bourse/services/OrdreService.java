package bourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bourse.dao.OrdreRepository;
import bourse.entities.*;

@CrossOrigin("*")
@RestController
public class OrdreService {
	@Autowired
	private OrdreRepository ordrerepository;
	
	@RequestMapping("/ordres")
	public List<Ordre> getAllOrdre(){
		return ordrerepository.findAll();
	}
	
	@RequestMapping("/ordresAchat")
	public List<Ordre> getOrdreAchat(String code){
		return ordrerepository.getOrdreAchatByCodeSociete(code);
	}
	
	@RequestMapping("/ordresVente")
	public List<Ordre> getOrdreVente(String code){
		return ordrerepository.getOrdreVenteByCodeSociete(code);
	}
	
	@RequestMapping("/save")
	public Ordre saveOrdre(Ordre o){
		return ordrerepository.save(o);
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAllOrdre(){
		ordrerepository.deleteAll();
	}
	
	@RequestMapping("/search")
	public List<Ordre> getOrdreByCode(String code){
		return ordrerepository.getOrdreByCodeSociete(code);
	}
}
