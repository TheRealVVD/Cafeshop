create table if not exists users
(
    id       bigserial primary key,
    name     varchar(255) not null,
    login    varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists orders
(
    id           bigserial primary key,
    total_amount int not null,
    total_price numeric(8, 2) not null,
    status varchar(255) not null,
    creation_time timestamp null,
    expiration_time timestamp null
);

create table if not exists dishes
(
    id bigserial primary key,
    title varchar(255) not null,
    description varchar(1024) not null,
    price numeric(8, 2) not null,
    weight numeric(8, 2) not null
);

create table if not exists users_orders
(
    user_id bigint not null,
    order_id bigint not null,
    primary key (user_id, order_id),
    constraint fk_users_orders_users foreign key (user_id) references users(id) on delete cascade on update no action,
    constraint fk_users_orders_orders foreign key (order_id) references orders(id) on delete cascade on update no action
);

create table if not exists users_roles
(
    user_id bigint not null,
    role varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users(id) on delete cascade on update no action
);