CREATE TABLE office_status
(
    status_id INT PRIMARY KEY,
    title     VARCHAR(255) NOT NULL
);

INSERT INTO office_status (status_id, title)
VALUES (1, 'FREE'),
       (2, 'NORMAL'),
       (3, 'MEDIUM'),
       (4, 'HEAVY');

create table office
(
    office_id     bigserial primary key,
    name          varchar(255)     not null,
    address       text             not null,
    latitude      double precision not null,
    longitude     double precision not null,
    city          varchar(100)     not null,
    postal_code   varchar(10)      not null,
    working_hours VARCHAR(20)      NOT NULL DEFAULT '00:00-00:00',
    status        INT              NOT NULL DEFAULT 1,
    FOREIGN KEY (status) REFERENCES office_status (status_id)
);

-- УДАЛИТЬ КОММЕНТАРИЙ ПОСЛЕ ВЫПОЛНЕНИЯ ТАСКИ ------ добавить из data (если чего-то нет в data - закинуть на рандоме); working_hours заносится СТОГО по паттерну 'HH:mm:HH:mm', пример '09:15-18:00' или 09:15-18:00
INSERT INTO office (name, address, latitude, longitude, city, postal_code, working_hours, status)
VALUES ();

create table office_filters
(
    filters_id          bigserial primary key,
    office_id           BIGINT  NOT NULL,
    ramp_having         boolean not null,
    cash_return         boolean not null,
    pickup_locations    boolean not null,
    retail_auto_lending boolean not null,
    FOREIGN KEY (office_id) REFERENCES office (office_id)
);

-- УДАЛИТЬ КОММЕНТАРИЙ ПОСЛЕ ВЫПОЛНЕНИЯ ТАСКИ ------ закидать рандомно false|true для каждого office_id
INSERT INTO office_filters (office_id, ramp_having, cash_return, pickup_locations, retail_auto_lending)
VALUES ();

create table workload
(
    workload_id bigserial primary key,
    office_id   BIGSERIAL NOT NULL,
    hour0       int       not null default 0,
    hour1       int       not null default 0,
    hour2       int       not null default 0,
    hour3       int       not null default 0,
    hour4       int       not null default 0,
    hour5       int       not null default 0,
    hour6       int       not null default 0,
    hour7       int       not null default 0,
    hour8       int       not null default 0,
    hour9       int       not null default 0,
    hour10      int       not null default 0,
    hour11      int       not null default 0,
    hour12      int       not null default 0,
    hour13      int       not null default 0,
    hour14      int       not null default 0,
    hour15      int       not null default 0,
    hour16      int       not null default 0,
    hour17      int       not null default 0,
    hour18      int       not null default 0,
    hour19      int       not null default 0,
    hour20      int       not null default 0,
    hour21      int       not null default 0,
    hour22      int       not null default 0,
    hour23      int       not null default 0,
    FOREIGN KEY (office_id) REFERENCES office (office_id)
);

-- УДАЛИТЬ КОММЕНТАРИЙ ПОСЛЕ ВЫПОЛНЕНИЯ ТАСКИ ------ закидать рандомно СТОГО от 0 до 100 (вкл.) для каждого office_id
INSERT INTO workload (office_id, hour0, hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9,
                      hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18, hour19, hour20,
                      hour21, hour22, hour23)
VALUES ();

create table atms
(
    atm_id        bigserial primary key,
    address       text             not null,
    bnkcd         varchar(32)      not null,
    code          varchar(32)      not null,
    latitude      double precision not null,
    longitude     double precision not null,
    working_hours VARCHAR(20)      NOT NULL DEFAULT '00:00-00:00'
);