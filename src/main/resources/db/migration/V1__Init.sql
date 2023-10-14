create table status
(
    status_id   bigserial
        primary key,
    name        varchar(255) not null,
    description text
);

create table office_filters
(
    filters_id          bigserial
        primary key,
    ramp_having         boolean not null,
    cash_return         boolean not null,
    pickup_locations    boolean not null,
    retail_auto_lending boolean not null
);


create table workload
(
    id bigserial
        primary key,
    hour0 int not null default 0,
    hour1 int not null default 0,
    hour2 int not null default 0,
    hour3 int not null default 0,
    hour4 int not null default 0,
    hour5 int not null default 0,
    hour6 int not null default 0,
    hour7 int not null default 0,
    hour8 int not null default 0,
    hour9 int not null default 0,
    hour10 int not null default 0,
    hour11 int not null default 0,
    hour12 int not null default 0,
    hour13 int not null default 0,
    hour14 int not null default 0,
    hour15 int not null default 0,
    hour16 int not null default 0,
    hour17 int not null default 0,
    hour18 int not null default 0,
    hour19 int not null default 0,
    hour20 int not null default 0,
    hour21 int not null default 0,
    hour22 int not null default 0,
    hour23 int not null default 0
);

create table atms
(
    atm_id    bigserial
        primary key,
    address   text             not null,
    bnkcd     varchar(32)      not null,
    code      varchar(32)      not null,
    latitude  double precision not null,
    longitude double precision not null,
    allday    boolean          not null
);

create table office
(
    office_id   bigserial
        primary key,
    name        varchar(255)     not null,
    address     text             not null,
    latitude    double precision not null,
    longitude   double precision not null,
    city        varchar(100)     not null,
    postal_code varchar(10)      not null,
    status_id   integer
        references status,
    filters_id  integer
        references office_filters,
    workload_id   integer
        references workload
);

-- Вставка данных в таблицу status
INSERT INTO status (name, description)
VALUES
    ('Статус 1', 'Описание статуса 1'),
    ('Статус 2', 'Описание статуса 2'),
    ('Статус 3', 'Описание статуса 3');

-- Вставка данных в таблицу office_filters
INSERT INTO office_filters (ramp_having, cash_return, pickup_locations, retail_auto_lending)
VALUES
    (true, false, true, true),
    (false, true, false, true),
    (true, true, true, false);

-- Вставка данных в таблицу office
INSERT INTO office (name, address, latitude, longitude, city, postal_code, status_id, filters_id)
VALUES
    ('ДО «Солнечногорский» Филиала № 7701 Банка ВТБ (ПАО)', '141506, Московская область, г. Солнечногорск, ул. Красная, д. 60', 51.1234, 7.5678, 'Москва', '12345', 1, 1),
    ('Офис 2', 'Адрес офиса 2', 52.5678, 8.1234, 'Москва', '67890', 2, 2),
    ('Офис 3', 'Адрес офиса 3', 53.9012, 9.3456, 'Ростов', '54321', 3, 3);
