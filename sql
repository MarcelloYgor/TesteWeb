create table tb_motorista(
id_motorista int primary key identity(1, 1),
nome varchar(20), 
dt_nasc datetime,
cpf varchar(15),
mod_carro varchar(15), 
status bit, 
sexo varchar(15));

drop table tb_motorista;

select * from tb_motorista;

INSERT INTO tb_motorista(nome, dt_nasc, cpf, mod_carro, status, sexo) VALUES ('Jão', '11/10/1980', '6454864168', 'Corolla', 1, 'Masculino');