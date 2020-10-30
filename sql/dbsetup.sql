CREATE DATABASE hardwhere;

USE hardwhere;

CREATE TABLE usuario (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  isAdmin TINYINT(1) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE peca (
  id INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(45) NOT NULL,
  modelo VARCHAR(45) NOT NULL,
  marca VARCHAR(45) NOT NULL,
  fabricante VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE favorito (
  id INT NOT NULL AUTO_INCREMENT,
  idUsuario INT NOT NULL,
  idPeca INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_favorito_usuario FOREIGN KEY (idUsuario) REFERENCES usuario(id),
  CONSTRAINT FK_favorito_peca FOREIGN KEY (idPeca) REFERENCES peca(id)
);

CREATE TABLE loja (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE produto (
  id INT NOT NULL AUTO_INCREMENT,
  preco DOUBLE(9,2) NOT NULL,
  url VARCHAR(600) NOT NULL,
  idPeca INT NOT NULL,
  idLoja INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_produto_peca FOREIGN KEY (idPeca) REFERENCES peca(id),
  CONSTRAINT FK_produto_loja FOREIGN KEY (idLoja) REFERENCES loja(id)
);

CREATE TABLE promocao (
  id INT NOT NULL AUTO_INCREMENT,
  porcentagemDesconto DOUBLE(9,2) NOT NULL,
  dataInicio DATE NOT NULL,
  dataFim DATE NOT NULL,
  idProduto INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_promocao_produto FOREIGN KEY (idProduto) REFERENCES produto(id)
);

CREATE TABLE avaliacao (
  id INT NOT NULL AUTO_INCREMENT,
  texto VARCHAR(300) NOT NULL,
  nota DOUBLE(9,2) NOT NULL,
  idPeca INT NOT NULL,
  idUsuario INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_avaliacao_peca FOREIGN KEY (idPeca) REFERENCES peca(id),
  CONSTRAINT FK_avaliacao_usuario FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);