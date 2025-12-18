package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.CancionEntity;

@Repository
public interface CancionRepository extends JpaRepository<CancionEntity, Integer> {
}
