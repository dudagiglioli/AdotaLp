alter table cidade add constraint FK_estado_cidade foreign key(idestado) references estado(id);
alter table adotantedoador add constraint FK_cidade_adotantedoador foreign key(idcidade) references cidade(id);
alter table situacaoanimal add constraint FK_animal_situacaoanimal foreign key(idanimal) references animal(id);
alter table animal add constraint FK_raca_animal foreign key(idraca) references raca(id);
alter table adocaodoacao add constraint FK_animal_adocaodoacao foreign key(idanimal) references animal(id);
alter table adocaodoacao add constraint FK_adotante_adocaodoacao foreign key(idadotante) references adotantedoador(id);
alter table adocaodoacao add constraint FK_doador_adocaodoacao foreign key(iddoador) references adotantedoador(id);
alter table fotosanimal add constraint FK_animal_fotosanimal foreign key(idanimal) references animal(id);

insert into estado(nome, sigla) values ('São Paulo', 'SP');
insert into estado(nome, sigla) values ('Rio de Janeiro', 'RJ');

insert into cidade(nome, idestado) values ('São Paulo', 1);
insert into cidade(nome, idestado) values ('Ourinhos', 1);
insert into cidade(nome, idestado) values ('Parati', 2);
insert into cidade(nome, idestado) values ('Rio de Janeiro', 2);

insert into adotantedoador(nome, cpf, telefone, email, dtnascimento, endereco, idcidade)
values ('Duda Giglioli', '51547682132', '(14)99812-1409', 'dudaguilice@gmail.com', '2000-08-19', 'Rua das Flores, 153', 1);
insert into adotantedoador(nome, cpf, telefone, email, dtnascimento, endereco, idcidade)
values ('Nickolas Mello', '76547682132', '(14)99821-0915', 'nickolasmello@gmail.com', '2000-02-21', 'Rua das  Margaridas, 17', 2);
insert into adotantedoador(nome, cpf, telefone, email, dtnascimento, endereco, idcidade)
values ('Guilherme Martos', '1154203610', '(14)99278-9520', 'guimartos@gmail.com', '2000-03-08', 'Rua do Girassol, 160', 4);

insert into raca(descricao) values ('Pinscher');
insert into raca(descricao) values ('Labrador');

insert into animal(nome, sexo, idade, porte, idraca) values ('Thanos', 'M', 3, 1, 1);
insert into animal(nome, sexo, idade, porte, idraca) values ('Gael', 'M', 2, 3, 2);
insert into animal(nome, sexo, idade, porte, idraca) values ('Kiwi', 'M', 5, 2, 1);

insert into situacaoanimal(situacao, idanimal) values ('Bom Estado', 1);
insert into situacaoanimal(situacao, idanimal) values ('Vacinas ok, bom estado', 2);
insert into situacaoanimal(situacao, idanimal) values ('Bom Estado', 3);

insert into adocaodoacao(iddoador, idadotante, idanimal, dataadocao) values (1, 2, 1, '2023-02-10');
insert into adocaodoacao(iddoador, idadotante, idanimal, dataadocao) values (2, 3, 2, '2023-03-06');
insert into adocaodoacao(iddoador, idadotante, idanimal, dataadocao) values (3, 1, 3, '2022-11-05');

insert into fotosanimal(fotoa, fotob, fotoc, fotod, fotoe, idanimal)
values('adjh', 'fdskjgh', 'dfjhb', 'dfskaljh', 'dkfsjgb', 2);
 

