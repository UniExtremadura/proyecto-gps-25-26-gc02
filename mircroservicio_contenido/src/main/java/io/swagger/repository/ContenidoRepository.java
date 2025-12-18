package io.swagger.repository;
import io.swagger.entity.ElementoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
@Repository
public interface ContenidoRepository extends JpaRepository<ElementoEntity, Integer>, JpaSpecificationExecutor<ElementoEntity> {
}
