create table itemDetails
(
   itemId integer not null,
   upc varchar(255) not null,
   price double not null,
   primary key(itemId)
);

create table itemSpecialPrice
(
   specialId integer not null,
   itemId integer not null,
   quantity integer not null,
   price double not null,
   primary key(specialId)
);

create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);