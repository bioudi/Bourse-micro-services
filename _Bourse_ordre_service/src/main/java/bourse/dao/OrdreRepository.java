package bourse.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bourse.entities.Ordre;

@RepositoryRestResource
public interface OrdreRepository extends JpaRepository<Ordre, Long> {
	@Query("select o from Ordre o where code_societe = :code")
	public List<Ordre> getOrdreByCodeSociete(@Param("code")String code);
	
	@Query("select o from Ordre o where code_societe = :code and type_ordre = 'Achat'")
	public List<Ordre> getOrdreAchatByCodeSociete(@Param("code")String code);
	
	@Query("select o from Ordre o where code_societe = :code and type_ordre = 'Vente'")
	public List<Ordre> getOrdreVenteByCodeSociete(@Param("code")String code);
}
