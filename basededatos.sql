-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto` DEFAULT CHARACTER SET utf8mb3 ;
USE `proyecto` ;

-- -----------------------------------------------------
-- Table `proyecto`.`actores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`actores` (
  `idActores` INT NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idActores`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `userp` VARCHAR(45) NOT NULL,
  `contra` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `user_UNIQUE` (`userp` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`actores_has_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`actores_has_usuario` (
  `usuario_idUsuario` INT NOT NULL,
  `Actores_idActores` INT NOT NULL,
  INDEX `fk_Actores_has_usuario_usuario_idx` (`usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Actores_has_usuario_Actores1_idx` (`Actores_idActores` ASC) VISIBLE,
  CONSTRAINT `fk_Actores_has_usuario_Actores1`
    FOREIGN KEY (`Actores_idActores`)
    REFERENCES `proyecto`.`actores` (`idActores`),
  CONSTRAINT `fk_Actores_has_usuario_usuario`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `proyecto`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`director` (
  `iddirector` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`iddirector`))
ENGINE = InnoDB
AUTO_INCREMENT = 243
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`directorgustos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`directorgustos` (
  `iddirectorgustos` INT NOT NULL AUTO_INCREMENT,
  `director_iddirector` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`iddirectorgustos`),
  INDEX `fk_directorgustos_director1_idx` (`director_iddirector` ASC) VISIBLE,
  INDEX `fk_directorgustos_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_directorgustos_director1`
    FOREIGN KEY (`director_iddirector`)
    REFERENCES `proyecto`.`director` (`iddirector`),
  CONSTRAINT `fk_directorgustos_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `proyecto`.`usuario` (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 70
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`genero` (
  `idgenero` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idgenero`))
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`generogusto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`generogusto` (
  `idgenerogusto` INT NOT NULL AUTO_INCREMENT,
  `genero_idgenero` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idgenerogusto`),
  INDEX `fk_generogusto_genero1_idx` (`genero_idgenero` ASC) VISIBLE,
  INDEX `fk_generogusto_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_generogusto_genero1`
    FOREIGN KEY (`genero_idgenero`)
    REFERENCES `proyecto`.`genero` (`idgenero`),
  CONSTRAINT `fk_generogusto_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `proyecto`.`usuario` (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 134
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`peliculas` (
  `idPeliculas` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`idPeliculas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`gustospeliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`gustospeliculas` (
  `Usuario_idUsuario` INT NOT NULL,
  `Usuario_has_Peliculascol` INT NOT NULL AUTO_INCREMENT,
  `peliculas_idPeliculas` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Usuario_has_Peliculascol`),
  INDEX `fk_Usuario_has_Peliculas_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_gustospeliculas_peliculas1_idx` (`peliculas_idPeliculas` ASC) VISIBLE,
  CONSTRAINT `fk_gustospeliculas_peliculas1`
    FOREIGN KEY (`peliculas_idPeliculas`)
    REFERENCES `proyecto`.`peliculas` (`idPeliculas`),
  CONSTRAINT `fk_Usuario_has_Peliculas_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `proyecto`.`usuario` (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 70
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `proyecto`.`peliculas_has_genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`peliculas_has_genero` (
  `genero_idgenero` INT NOT NULL,
  `peliculas_idPeliculas` VARCHAR(30) NOT NULL,
  INDEX `fk_peliculas_has_genero_genero1_idx` (`genero_idgenero` ASC) VISIBLE,
  INDEX `fk_peliculas_has_genero_peliculas1_idx` (`peliculas_idPeliculas` ASC) VISIBLE,
  CONSTRAINT `fk_peliculas_has_genero_genero1`
    FOREIGN KEY (`genero_idgenero`)
    REFERENCES `proyecto`.`genero` (`idgenero`),
  CONSTRAINT `fk_peliculas_has_genero_peliculas1`
    FOREIGN KEY (`peliculas_idPeliculas`)
    REFERENCES `proyecto`.`peliculas` (`idPeliculas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
