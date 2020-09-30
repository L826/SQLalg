CREATE TABLE IF NOT EXISTS aluno(
  nome VARCHAR(120),
  matricula CHAR(6),
  inicio DATE,
  mediaAluno FLOAT,
  CONSTRAINT pkaluno PRIMARY KEY (matricula)
);

CREATE TABLE IF NOT EXISTS disciplina(
  codigo INT,
  nome VARCHAR(30),
  horario TIME,
  CONSTRAINT pkdisc PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS faz(
  ra CHAR(6),
  codigo INT,
  nomeDisc VARCHAR(30),
  CONSTRAINT pkfaz PRIMARY KEY (ra, codigo),
  CONSTRAINT fk1 FOREIGN KEY (ra) REFERENCES aluno(matricula),
  CONSTRAINT fk2 FOREIGN KEY (codigo, nomeDisc) REFERENCES disciplina(codigo, nome)
);

INSERT INTO aluno(nome, matricula, inicio, mediaAluno) VALUES ('Aluno A', '8675-0', '2020-10-01', 5.5);

INSERT INTO aluno(nome, matricula, inicio, mediaAluno) VALUES ('Aluno B', '3463-1', '2014-01-31', 8);

INSERT INTO aluno(nome, matricula, inicio, mediaAluno) VALUES ('Aluno C', '7245-6', '2019-12-25', 7.5);

INSERT INTO aluno(nome, matricula, inicio, mediaAluno) VALUES ('Aluno D', '9233-7', '2016-09-04', 4);

INSERT INTO aluno(nome, matricula, inicio, mediaAluno) VALUES ('Aluno E', '0783-9', '2020-10-01', 6);

INSERT INTO disciplina(codigo, nome, horario) VALUES (1, 'Materia 1', '08:00:00');

INSERT INTO disciplina(codigo, nome, horario) VALUES (2, 'Materia 2', '08:30:00');

INSERT INTO disciplina(codigo, nome, horario) VALUES (3, 'Materia 1', '10:00:00');

INSERT INTO disciplina(codigo, nome, horario) VALUES (4, 'Materia 3', '16:00:00');

INSERT INTO disciplina(codigo, nome, horario) VALUES (5, 'Materia 3', '14:00:00');

INSERT INTO faz(ra, codigo, nomeDisc) VALUES ('3463-1', 1, 'Materia 1');

INSERT INTO faz(ra, codigo, nomeDisc) VALUES ('7245-6', 5, 'Materia 3');

INSERT INTO faz(ra, codigo, nomeDisc) VALUES ('0783-9', 5, 'Materia 3');

SELECT nome, matricula FROM aluno, faz WHERE matricula = faz.ra GROUP BY matricula;

SELECT AVG(mediaAluno) FROM aluno;

SELECT COUNT(nome) FROM disciplina WHERE nome = 'Materia 3';

SELECT * FROM faz;

SELECT inicio FROM aluno WHERE nome = (SELECT nome FROM aluno WHERE matricula = '0783-9') ORDER BY nome;

UPDATE disciplina SET nome = 'Materia 4';

UPDATE aluno SET nome = 'Aluno F' WHERE mediaAluno < 6;

SELECT nome, horario FROM disciplina WHERE codigo <> 3;

SELECT * FROM aluno ORDER BY mediaAluno;

DROP TABLE faz;

DROP TABLE aluno;

DROP TABLE disciplina;

