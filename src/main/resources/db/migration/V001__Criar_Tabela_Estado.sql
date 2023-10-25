create table estado(
    id int not null primary key auto_increment,
    nomeestado varchar(30),
    uf char(2),
    ibge int(2) DEFAULT NULL,
    pais int(3) DEFAULT NULL,
    ddd varchar(50) DEFAULT NULL
);
