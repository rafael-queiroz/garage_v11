package br.com.rqueiroz.material.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @Column(name = "codigo")
    String codigo;

    @NotEmpty
    @Column(name = "descricao")
    String descricao;

    @Column(name = "vida_util_em_km")
    BigDecimal vidaUtilEmKm;

    @Column(name = "vida_util_em_meses")
    BigDecimal vidaUtilEmMeses;

    @Column(name = "posicao_no_veiculo")
    String posicaoNoVeiculo;

    @Column(name = "codigo_de_referencia")
    String codigoDeReferencia;

    @NotNull
    @Column(name = "fg_produto_controlado")
    Boolean produtoControlado;

    @NotNull
    @Column(name = "fg_garantia")
    Boolean garantia;

    @NotNull
    @Column(name = "fg_montagem")
    Boolean produtoDeMontagem;

    @NotNull
    @Column(name = "fg_serializacao")
    Boolean possuiSerializacao;

    @NotNull
    @Column(name = "fg_requisicao_especial")
    Boolean requisicaoEspecial;

    @Column(name = "peso_em_kg")
    Double peso;

    @Column(name = "ultimo_valor_comprado", precision = 19, scale = 2)
    BigDecimal ultimoValorComprado;

    @Column(name = "valor_medio", precision = 19, scale = 2)
    BigDecimal valorMedio;

}
