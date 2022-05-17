create table user_account(
	user_id integer,
	user_name varchar(50) not null,
	password varchar(50) not null,
	constraint pk_user primary key (user_id)
);

create table address(
	address_id integer,
	country varchar(50) not null,
	city varchar(50),
	zip_code varchar(10),
	street varchar(50),
	constraint pk_address primary key (address_id)
);

create table contact(
	contact_id integer,
	address_id integer,
	user_id integer not null,
	email varchar(50),
	name varchar(50) not null,
	photo bytea,
	constraint pk_contact primary key (contact_id)
);

create table phone_number(
	phone_id integer,
	contact_id integer not null,
	phone_number varchar(20) not null,
	constraint pk_phone_number primary key (phone_id)
);

alter table phone_number
add constraint fk_contact
foreign key (contact_id) references contact(contact_id)
on delete cascade;


alter table contact
add constraint fk_address
foreign key (address_id) references address(address_id);

alter table contact
add constraint fk_user
foreign key (user_id) references user_account(user_id)
on delete cascade;



