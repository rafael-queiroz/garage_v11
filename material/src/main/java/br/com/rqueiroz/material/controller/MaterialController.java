package br.com.rqueiroz.material.controller;


import br.com.rqueiroz.material.model.Material;
import br.com.rqueiroz.material.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(value = "MaterialEndpoint")
@RestController
@RequestMapping("/materiais")
public class MaterialController {

    @Autowired
    MaterialService service;


    @ApiOperation(value = "Create a new material")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create (@RequestBody Material material, UriComponentsBuilder uriComponentsBuilder){
        Long id = service.create(material);

        final URI uri = uriComponentsBuilder.path("/{id}")
                .build(id);

        return ResponseEntity.created(uri)
                .build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Material> findlAll(){
        return service.findAll();
    }

}
