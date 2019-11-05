drop table if exists usuario;

create table usuario (
	nome varchar(25) not null,
	id identity primary key not null,
	data timestamp not null,
	mensagem varchar(40) not null
);

insert into usuario(nome, id, data, mensagem) values('Marcos', 11111, '2019-10-03 18:47:52.69', 'primeiro');
insert into usuario(nome, id, data, mensagem) values('Pedro', 22222, '2019-10-02 18:47:52.69', 'segundo');
insert into usuario(nome, id, data, mensagem) values('João', 33333, '2019-10-01 18:47:52.69', 'terceiro');