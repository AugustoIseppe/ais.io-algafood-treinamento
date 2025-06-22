create table role (
	id bigint not null auto_increment,
	authority varchar(255),
	primary key (id)
) engine=InnoDB default charset=utf8;

create table user_role (
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references usuario(id),
    foreign key (role_id) references role(id)
) engine=InnoDB default charset=utf8;
