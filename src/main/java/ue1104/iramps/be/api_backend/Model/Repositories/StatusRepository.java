package ue1104.iramps.be.api_backend.Model.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import ue1104.iramps.be.api_backend.Model.BL.Status;

import java.util.List;


public interface StatusRepository extends PagingAndSortingRepository<Status,Long>, CrudRepository<Status,Long>  {
    Status findByNom(@Param("nom") String nom); //Nom étant un champs unique, nous n'aurons qu'un seul enregistrement.
    Status findById(@Param("id") int id);
    @Modifying
    @Query("delete from Status s where s.nom=:nom")
    void deleteStatus(@Param("nom") String nom);
}
