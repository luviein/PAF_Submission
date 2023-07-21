create database mybnb;

create table acc_occupancy(
	acc_id int not null,
    vacancy int,
    constraint pk_acc_id primary key (acc_id)
);

create table reservations(
	resv_id int not null,
    name varchar(128),
    email varchar(128),
    acc_id int not null,
    arrival_date date,
    duration int not null,
    constraint pk_resv_id primary key (resv_id),
    constraint fk_acc_id foreign key (acc_id) references acc_occupancy(acc_id)
    
);