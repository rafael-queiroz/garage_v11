package br.com.rqueiroz.material.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Material {

    Long id;
    BigDecimal codigo;
    String descricao;
    BigDecimal vidaUtilEmKm;
    BigDecimal vidaUtilEmMeses;
    String posicaoNoVeiculo;
    String codigoDeReferencia;
    Boolean produtoControlado;
    Boolean garantia;
    Boolean produtoDeMontagem;
    Boolean possuiSerializacao;
    Boolean requisicaoEspecial;
    Double peso;
    BigDecimal ultimoValorComprado;
    BigDecimal valorMedio;

}
