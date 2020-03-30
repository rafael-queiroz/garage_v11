package br.com.rqueiroz.material.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "materiais", itemRelation = "material")
@JsonInclude(Include.NON_NULL)
public class MaterialModel extends RepresentationModel<MaterialModel> {

    Long id;

    String codigo;

    @NotEmpty(message = "{description.not.blank}")
    String descricao;

    @NotNull(message = "{flag.not.null}")
    Boolean produtoControlado;

    @NotNull(message = "{flag.not.null}")
    Boolean garantia;

    @NotNull(message = "{flag.not.null}")
    Boolean produtoDeMontagem;

    @NotNull(message = "{flag.not.null}")
    Boolean possuiSerializacao;

    @NotNull(message = "{flag.not.null}")
    Boolean requisicaoEspecial;

    BigDecimal vidaUtilEmKm;
    BigDecimal vidaUtilEmMeses;
    String posicaoNoVeiculo;
    String codigoDeReferencia;
    Double peso;
    BigDecimal ultimoValorComprado;
    BigDecimal valorMedio;

}
