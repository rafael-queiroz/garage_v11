package br.com.rqueiroz.material.model;

import br.com.rqueiroz.material.controller.MaterialController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class MaterialModelAssembler extends RepresentationModelAssemblerSupport<MaterialEntity, MaterialModel> {

    public MaterialModelAssembler() {
        super(MaterialController.class, MaterialModel.class);
    }

    @Override
    public MaterialModel toModel(MaterialEntity entity) {
        MaterialModel materialModel = instantiateModel(entity);

        materialModel.add(linkTo(
                methodOn(MaterialController.class)
                        .getMaterialById(entity.getId()))
                .withSelfRel());

        materialModel.setId(entity.getId());
        materialModel.setCodigo(entity.getCodigo());
        materialModel.setDescricao(entity.getDescricao());
        materialModel.setVidaUtilEmKm(entity.getVidaUtilEmKm());
        materialModel.setVidaUtilEmMeses(entity.getVidaUtilEmMeses());
        materialModel.setPosicaoNoVeiculo(entity.getPosicaoNoVeiculo());
        materialModel.setCodigoDeReferencia(entity.getCodigoDeReferencia());
        materialModel.setProdutoControlado(entity.getProdutoControlado());
        materialModel.setGarantia(entity.getGarantia());
        materialModel.setProdutoDeMontagem(entity.getProdutoDeMontagem());
        materialModel.setPossuiSerializacao(entity.getPossuiSerializacao());
        materialModel.setRequisicaoEspecial(entity.getRequisicaoEspecial());
        materialModel.setPeso(entity.getPeso());
        materialModel.setUltimoValorComprado(entity.getUltimoValorComprado());
        materialModel.setValorMedio(entity.getValorMedio());

        return materialModel;
    }

    @Override
    public CollectionModel<MaterialModel> toCollectionModel(Iterable<? extends MaterialEntity> entities) {
        CollectionModel<MaterialModel> materialModels = super.toCollectionModel(entities);

        materialModels.add(linkTo(methodOn(MaterialController.class).getAllMateriais()).withSelfRel());

        return materialModels;
    }

    /*
    private List<ActorModel> toActorModel(List<ActorEntity> actors) {
        if (actors.isEmpty())
            return Collections.emptyList();

        return actors.stream()
                .map(actor -> ActorModel.builder()
                        .id(actor.getId())
                        .firstName(actor.getFirstName())
                        .lastName(actor.getLastName())
                        .build()
                        .add(linkTo(
                                methodOn(WebController.class)
                                        .getActorById(actor.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }
    */
}
