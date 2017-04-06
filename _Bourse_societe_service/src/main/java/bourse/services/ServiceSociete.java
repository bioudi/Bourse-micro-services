package bourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bourse.dao.SocieteRepository;
import bourse.entities.Societe;

@RestController
@CrossOrigin("*")
@RefreshScope
public class ServiceSociete {
	@Autowired
	private SocieteRepository societerepository;
	
	@RequestMapping("/societes")
	public List<Societe> getAllSociete(){
		return societerepository.findAll();
	}
	
	@RequestMapping("/societesParMC")
	public List<Societe> getSocietesParMC(@RequestParam(defaultValue="")String mc){
		return societerepository.getSocietesParMC("%"+mc+"%");
	}
	
	@RequestMapping("/societesParC")
	public List<Societe> getSocietesParC(@RequestParam(defaultValue="MA")String code){
		return societerepository.getSocietesParC(code);
	}
	
}
