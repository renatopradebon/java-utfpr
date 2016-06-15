DROP TABLE IF EXISTS `javaes`.`Imagem` ;

CREATE  TABLE IF NOT EXISTS `javaes`.`Imagem` (
  `idImagem` INT NOT NULL AUTO_INCREMENT ,
  `quadrado` MEDIUMBLOB NOT NULL ,
  `triangulo` MEDIUMBLOB NOT NULL ,
  `circulo` MEDIUMBLOB NOT NULL ,
  PRIMARY KEY (`idImagem`) )
ENGINE = InnoDB;