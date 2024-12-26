-- sql script to create the "product" table whenever the application is uploaded --
create table tb_product (
    id varchar(255) not null primary key,
    name varchar(50) not null,
    description varchar(300),
    price numeric(18, 2)
);
