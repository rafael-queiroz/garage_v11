package br.com.rqueiroz.material.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<MaterialEntity, Long> {
}
