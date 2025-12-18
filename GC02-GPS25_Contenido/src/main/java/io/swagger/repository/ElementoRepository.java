package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.ElementoEntity;

@Repository
public interface ElementoRepository extends JpaRepository<ElementoEntity, Integer> {
}
