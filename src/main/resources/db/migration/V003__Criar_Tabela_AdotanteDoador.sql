create table adotantedoador(
    id int not null primary key auto_increment,
    idcidade int not null,
    nome varchar(45),
    cpf varchar(20),
    telefone varchar(20),
    email varchar(50),
    dtnascimento date,
    endereco varchar(30)
);