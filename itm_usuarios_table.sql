USE projeto;

CREATE TABLE projeto.itmn_usuarios(
  cod_usuario INT NOT NULL AUTO_INCREMENT,
  racf_usuario VARCHAR(7) NOT NULL,
  senha_usuario VARCHAR(8) NOT NULL,
  nome_usuario VARCHAR(50) NOT NULL,
  endereco_usuario VARCHAR(60) NOT NULL,
  email_usuario VARCHAR(80) NOT NULL,
  data_modificacao_registro DATETIME,
  PRIMARY KEY(cod_usuario,racf_usuario,email_usuario));
  
DESCRIBE itmn_usuarios;

INSERT INTO projeto.itmn_usuarios(
    racf_usuario,senha_usuario,nome_usuario,endereco_usuario,email_usuario,data_modificacao_registro)
    VALUES("cleitce","janela01","Cleiton Silva","Rua X, 100","cleitce@gmail.com",now());
    
SELECT * FROM projeto.itmn_usuarios;