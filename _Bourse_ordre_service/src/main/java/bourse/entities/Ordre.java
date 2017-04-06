package bourse.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ordre implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ordre;
	private float prix_action;
	private int qte;
	private String date_ordre;
	private int nbre_actions;
	private String code_societe;
	private String type_ordre;
	private String nom_societe;
	
	public Ordre() {
		super();
	}

	public Ordre(float prix_action, int qte, String date_ordre, int nbre_actions, String code_societe, String type_ordre, String nom_societe) {
		super();
		this.prix_action = prix_action;
		this.qte = qte;
		this.date_ordre = date_ordre;
		this.nbre_actions = nbre_actions;
		this.code_societe = code_societe;
		this.type_ordre = type_ordre;
		this.nom_societe = nom_societe;
	}
	
	public String getNom_societe() {
		return nom_societe;
	}

	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}
	
	public Long getId_ordre() {
		return id_ordre;
	}

	public void setId_ordre(Long id_ordre) {
		this.id_ordre = id_ordre;
	}

	public float getPrix_action() {
		return prix_action;
	}

	public void setPrix_action(float prix_action) {
		this.prix_action = prix_action;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public String getDate_ordre() {
		return date_ordre;
	}

	public void setDate_ordre(String date_ordre) {
		this.date_ordre = date_ordre;
	}

	public int getNbre_actions() {
		return nbre_actions;
	}

	public void setNbre_actions(int nbre_actions) {
		this.nbre_actions = nbre_actions;
	}

	public String getCode_societe() {
		return code_societe;
	}

	public void setCode_societe(String code_societe) {
		this.code_societe = code_societe;
	}
	
	public String getType_ordre() {
		return type_ordre;
	}

	public void setType_ordre(String type_ordre) {
		this.type_ordre = type_ordre;
	}
	
}
