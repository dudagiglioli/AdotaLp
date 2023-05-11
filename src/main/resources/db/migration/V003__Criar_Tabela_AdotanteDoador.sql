create table adotantedoador(
    id int not null primary key auto_increment,
    idcidade int not null,
    nome varchar(45),
    cpf char(11),
    telefone varchar(15),
    email varchar(50),
    dtnascimento date,
    endereco varchar(30)
);