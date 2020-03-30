package br.com.rqueiroz.material.service;

import br.com.rqueiroz.material.converter.DozerConverter;
import br.com.rqueiroz.material.model.MaterialEntity;
import br.com.rqueiroz.material.model.MaterialModel;
import br.com.rqueiroz.material.model.MaterialModelAssembler;
import br.com.rqueiroz.material.model.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class MaterialService {

    @Autowired
    MaterialRepository repository;

    @Autowired
    MaterialModelAssembler materialModelAssembler;

    @Autowired
    PagedResourcesAssembler<MaterialEntity> pagedResourcesAssembler;


    public PagedModel<MaterialModel> findAllPageable(Pageable pageable) {
        var page = repository.findAll(pageable);
        return pagedResourcesAssembler.toModel(page, materialModelAssembler);
    }

    public MaterialModel create(MaterialModel materialModel) {
        var entity = DozerConverter.parseObject(materialModel, MaterialEntity.class);
        var materialEntity = repository.save(entity);
        return materialModelAssembler.toModel(materialEntity);
    }

    public void delete(Long id) {
        Optional<MaterialEntity> entity = repository.findById(id);
        repository.delete(entity.get());
    }

    /*
    public MaterialModel findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, MaterialModel.class);
    }


    @Transactional
    @Validated
    public MaterialModel create (@Valid MaterialModel material){
        var entity = DozerConverter.parseObject(material, MaterialEntity.class);
        var vo = DozerConverter.parseObject(repository.save(entity), MaterialModel.class);
        return vo;
    }

    public PagedModel<MaterialModel> findAllPageable(Pageable pageable) {
        Page<MaterialEntity> materialEntities = repository.findAll(pageable);
        PagedModel<MaterialModel> materialModelsPage = pagedResourcesAssembler.toModel(materialEntities, assembler);
        return materialModelsPage;
    }





    // PRIVATE METHODS
    MaterialModel convertToMaterial(MaterialEntity entity) {
        return DozerConverter.parseObject(entity, MaterialModel.class);
    }
    /*
     */
}
