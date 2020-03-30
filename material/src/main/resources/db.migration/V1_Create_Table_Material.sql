/*
CREATE TABLE IF NOT EXISTS `material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` decimal(19,2) DEFAULT NOT NULL,
  `codigo_de_referencia` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NOT NULL,
  `fg_garantia` bit(1) DEFAULT NOT NULL,
  `peso_em_kg` double DEFAULT NULL,
  `posicao_no_veiculo` varchar(255) DEFAULT NULL,
  `fg_serializacao` bit(1) DEFAULT NOT NULL,
  `produto_controlado` bit(1) DEFAULT NOT NULL,
  `fg_montagem` bit(1) DEFAULT NOT NULL,
  `fg_requisicao_especial` bit(1) DEFAULT NOT NULL,
  `ultimo_valor_comprado` decimal(19,4) DEFAULT NULL,
  `valor_medio` decimal(19,2) DEFAULT NULL,
  `vida_util_em_km` decimal(19,2) DEFAULT NULL,
  `vida_util_em_meses` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
*/