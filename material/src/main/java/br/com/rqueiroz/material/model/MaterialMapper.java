package br.com.rqueiroz.material.model;

import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface MaterialMapper {

    MaterialEntity toMaterialEntity(Material material);

    Material toMaterial(MaterialEntity materialEntity);

}
