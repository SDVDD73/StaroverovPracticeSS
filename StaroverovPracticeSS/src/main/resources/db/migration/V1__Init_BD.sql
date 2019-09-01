create sequence hibernate_sequence start 1 increment 1;
create table message (
    id int8 not null,
    enable boolean not null,
    text varchar(2048),
    time timestamp,
    room_id int8,
    user_id int8,
    primary key (id)
);
create table roles (id int8 not null, role_name varchar(255), primary key (id));
create table room (id int8 not null, enable boolean not null, room_name varchar(255), primary key (id));
create table room_user_role (id int8 not null, role_id int8, room_id int8, user_id int8, primary key (id));
create table usr (id int8 not null, enable boolean not null, password varchar(255), username varchar(255), primary key (id));
alter table message add constraint FKl1kg5a2471cv6pkew0gdgjrmo foreign key (room_id) references room;
alter table message add constraint FK70bv6o4exfe3fbrho7nuotopf foreign key (user_id) references usr;
alter table room_user_role add constraint FK4swo2cxoavk5xy5tasa669sj1 foreign key (role_id) references roles;
alter table room_user_role add constraint FKbmjpegf3h3048p51g3e3ua5qc foreign key (room_id) references room;
alter table room_user_role add constraint FKj08meis80ydmt5d62rkx8nv08 foreign key (user_id) references usr;