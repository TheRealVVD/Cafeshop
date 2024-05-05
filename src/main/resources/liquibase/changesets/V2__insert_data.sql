insert into users (name, login, password)
values ('Zhamso Gungaev', 'pussydestroyer@gmail.com', '$2a$10$rZDe5/ekA1AtaUdt4RMUgOBwnveahoHIn65CIdtQ0nNFxjeCcTAnS'),
       ('Vlad Verbitsky', 'vlad@mail.ru', '$2a$10$hyeEw8st5Qhi9LcZchuEXO5CRJDv0yB.zBKfeOYowuCWSyWFaMNXO'),
       ('Katya Verbitskaya', 'katya@yahoo.com', '$2a$10$q.2FTeZhrI5wHyRAa7v.uOsFhQy28NyqC4f2y9aAio2ms.ebtM3CW');

insert into orders (total_amount, total_price, status, creation_time)
values (10, 2998.11, 'DELIVERED', '2024-04-01 00:00:00'),
       (2, 100.18, 'ACCEPTED', '2024-01-03 00:01:03'),
       (3, 200.00, 'ON_THE_WAY', '2024-02-02 00:02:02'),
       (9, 777.77, 'COOKING', '2024-03-01 00:03:01');

insert into users_orders (user_id, order_id)
values (1, 2),
       (1, 3),
       (2, 1),
       (3, 4);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_USER');