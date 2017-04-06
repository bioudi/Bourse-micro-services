package bourse.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Societe implements Serializable {
	@Id
	@GeneratedValue
	private Long id_societe;
	private String code_societe;
	private String nom_societe;
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Societe(String nom_societe,String code_societe) {
		super();
		this.nom_societe = nom_societe;
		this.code_societe = code_societe;
	}

	public Long getIdSociete() {
		return id_societe;
	}

	public void setIdSociete(Long id_societe) {
		this.id_societe = id_societe;
	}

	public String getCode_societe() {
		return code_societe;
	}

	public void setCode_societe(String code_societe) {
		this.code_societe = code_societe;
	}

	public String getNom_societe() {
		return nom_societe;
	}

	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}

	
	
}
