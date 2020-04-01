package br.com.rqueiroz.material.repository;

import br.com.rqueiroz.material.model.MaterialEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends PagingAndSortingRepository<MaterialEntity, Long> {



}
