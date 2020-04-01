CREATE TABLE `material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `codigo_de_referencia` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `fg_garantia` bit(1) NOT NULL,
  `peso_em_kg` double DEFAULT NULL,
  `posicao_no_veiculo` varchar(255) DEFAULT NULL,
  `fg_serializacao` bit(1) NOT NULL,
  `fg_produto_controlado` bit(1) NOT NULL,
  `fg_montagem` bit(1) NOT NULL,
  `fg_requisicao_especial` bit(1) NOT NULL,
  `ultimo_valor_comprado` decimal(19,2) DEFAULT NULL,
  `valor_medio` decimal(19,2) DEFAULT NULL,
  `vida_util_em_km` decimal(19,2) DEFAULT NULL,
  `vida_util_em_meses` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
