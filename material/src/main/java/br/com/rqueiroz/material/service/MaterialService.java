package br.com.rqueiroz.material.service;

import br.com.rqueiroz.material.model.Material;
import br.com.rqueiroz.material.model.MaterialEntity;
import br.com.rqueiroz.material.model.MaterialMapper;
import br.com.rqueiroz.material.model.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class MaterialService {

    @Autowired
    MaterialMapper mapper;

    @Autowired
    MaterialRepository repository;

    @Transactional
    @Validated
    public Long create (@Valid Material material){
        MaterialEntity materialEntity = mapper.toMaterialEntity(material);
        repository.save(materialEntity);

        return materialEntity.getId();
    }

    public List<Material> findAll(){
        List<Material> materiais = new ArrayList<>();
        repository.findAll().forEach(me -> materiais.add(mapper.toMaterial(me)));

        return materiais;
    }

}
