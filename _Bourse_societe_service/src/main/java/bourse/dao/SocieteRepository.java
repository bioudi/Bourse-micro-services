package bourse.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import bourse.entities.Societe;

@RepositoryRestResource
public interface SocieteRepository extends JpaRepository<Societe, Long> {
	
	@Query("select s from Societe s where s.nom_societe like :mc")
	public List<Societe> getSocietesParMC(@Param("mc")String mc);
	
	@Query("select s from Societe s where s.code_societe = :code")
	public List<Societe> getSocietesParC(@Param("code")String code);
}
