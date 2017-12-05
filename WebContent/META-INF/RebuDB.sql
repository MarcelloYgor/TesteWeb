SELECT * FROM INFORMATION_SCHEMA.TABLES;

CREATE TABLE tb_rebu_motorista (
	id_motorista INT NOT NULL IDENTITY(1,1),
	nome VARCHAR(35) NOT NULL,
	dt_nasc DATE NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	mod_carro VARCHAR(20) NOT NULL,
	status BIT NOT NULL,
	sexo VARCHAR(10) NOT NULL
);

ALTER TABLE tb_rebu_motorista
	ADD CONSTRAINT pk_motorista_id
		PRIMARY KEY (id_motorista);
		
CREATE TABLE tb_rebu_passageiro (
	id_passageiro INT NOT NULL IDENTITY(1,1),
	nome VARCHAR(35) NOT NULL,
	dt_nasc DATE NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	sexo VARCHAR(10) NOT NULL
);

ALTER TABLE tb_rebu_passageiro
	ADD CONSTRAINT pk_passageiro_id
		PRIMARY KEY (id_passageiro);
		
CREATE TABLE tb_rebu_corrida (
	id_corrida INT NOT NULL IDENTITY(1,1),
	id_mot_corrida INT NOT NULL,
	id_pas_corrida INT NOT NULL,
	vl_corrida FLOAT NOT NULL
);

ALTER TABLE tb_rebu_corrida
	ADD CONSTRAINT pk_corrida_id
		PRIMARY KEY (id_corrida);

ALTER TABLE tb_rebu_corrida
	ADD CONSTRAINT fk_mot_corrida_id
		FOREIGN KEY (id_mot_corrida)
			REFERENCES tb_rebu_motorista(id_motorista);
		
ALTER TABLE tb_rebu_corrida
	ADD CONSTRAINT fk_pas_corrida_id
		FOREIGN KEY (id_pas_corrida)
			REFERENCES tb_rebu_passageiro(id_passageiro);
			
select * from tb_rebu_motorista;

delete from tb_rebu_motorista;

INSERT INTO tb_rebu_motorista(nome, dt_nasc, cpf, mod_carro, status, sexo) VALUES ('Jão', convert(datetime, '2017-11-07'), '12345678946', 'Corsa', 1, 'Masculino');

select * from tb_rebu_passageiro;

select * from tb_rebu_corrida;