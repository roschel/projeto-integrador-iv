package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.entities.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
