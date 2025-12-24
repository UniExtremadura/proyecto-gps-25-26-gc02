package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;

import java.util.List;

@Repository
public interface UsuarioValoraElemRepository extends JpaRepository<UsuarioValoraElemEntity, UsuarioValoraElemId>{
   List<UsuarioValoraElemEntity> findById_IdElem(Integer idElem);

}
