package br.com.rqueiroz.material.controller;


import br.com.rqueiroz.material.model.MaterialEntity;
import br.com.rqueiroz.material.model.MaterialModel;
import br.com.rqueiroz.material.model.MaterialModelAssembler;
import br.com.rqueiroz.material.model.MaterialRepository;
import br.com.rqueiroz.material.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Api(value = "MaterialEndpoint")
@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    @Autowired
    MaterialRepository repository;

    @Autowired
    MaterialService service;

    @Autowired
    MaterialModelAssembler materialModelAssembler;

    @Autowired
    private PagedResourcesAssembler<MaterialEntity> pagedResourcesAssembler;


    //@ApiOperation(value = "Find a specific material by your ID" )
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<MaterialModel> getMaterialById(@PathVariable(value = "id") Long id){
        return repository.findById(id)
                .map(materialModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    //@ApiOperation(value = "Find all material" )
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<CollectionModel<MaterialModel>> getAllMateriais() {
        List<MaterialEntity> materialEntities = (List<MaterialEntity>) repository.findAll();
        return new ResponseEntity<>(
                materialModelAssembler.toCollectionModel(materialEntities),
                HttpStatus.OK);
    }


    //@ApiOperation(value = "Find all materil pageable" )
    @GetMapping(value = "/list", produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<PagedModel<MaterialModel>> findAllMateriaisPageable(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                              @RequestParam(value = "limit", defaultValue = "30") int limit,
                                                                              @RequestParam(value = "direction", defaultValue = "asc") String direction,
                                                                              @RequestParam(value = "order", defaultValue = "descricao") String order){

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by(sortDirection, order));
        PagedModel<MaterialModel> resources = service.findAllPageable(pageableRequest);
        return ResponseEntity.ok(resources);
    }

    //@ApiOperation(value = "Create a new material")
    @PostMapping(consumes = { "application/json", "application/xml", "application/x-yaml" },
                 produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<MaterialModel> create(@RequestBody @Valid MaterialModel model){
        MaterialModel materialModel = service.create(model);
        return new ResponseEntity<>(materialModel, HttpStatus.CREATED);
    }

    //@ApiOperation(value = "Delete a specific person by your ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }



}
