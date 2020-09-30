CREATE TABLE IF NOT EXISTS evento(
  nome VARCHAR(20),
  horario DATETIME,
  convidados INT,
  CONSTRAINT pkaluno PRIMARY KEY (nome)
);

CREATE TABLE IF NOT EXISTS participante(
  nome VARCHAR(50),
  documento CHAR(8),
  aniversario DATE,
  CONSTRAINT pkdisc PRIMARY KEY (documento)
);

INSERT INTO evento(nome, horario, convidados) VALUES ('evento 1', '2020-09-30 14:10:00', 50);

INSERT INTO evento(nome, horario, convidados) VALUES ('evento 2', '2020-09-30 12:00:00', 30);

INSERT INTO participante(nome, documento, aniversario) VALUES ('Rafael', '12345678', '2010-06-30');

INSERT INTO participante(nome, documento, aniversario) VALUES ('Paulo', '87654321', '2010-09-30');

INSERT INTO participante(nome, documento, aniversario) VALUES ('Alice', '87651234', '2020-01-05');

SELECT nome FROM evento WHERE horario <> '2020-09-30 14:10:00';

UPDATE evento SET horario = '2020-09-30 21:00:00' WHERE convidados < 40;

DELETE FROM participante WHERE nome = 'Alice';

SELECT * FROM participante;

