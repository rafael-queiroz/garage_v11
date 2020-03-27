package br.com.rqueiroz.material.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "a_produto")
@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    Long id;
    
    @Column(name = "codigo")
    BigDecimal codigo;

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

    @Column(name = "produto_controlado")
    Boolean produtoControlado;

    @Column(name = "fg_garantia")
    Boolean garantia;

    @Column(name = "fg_montagem")
    Boolean produtoDeMontagem;

    @Column(name = "fg_serializacao")
    Boolean possuiSerializacao;

    @Column(name = "fg_requisicao_especial")
    Boolean requisicaoEspecial;

    @Column(name = "peso_em_kg")
    Double peso;

    @Column(name = "ultimo_valor_comprado", precision = 19, scale = 4)
    BigDecimal ultimoValorComprado;

    @Column(name = "valor_medio")
    BigDecimal valorMedio;

}
