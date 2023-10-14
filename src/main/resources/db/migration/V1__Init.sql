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

INSERT INTO office (name, address, latitude, longitude, city, postal_code, working_hours, status)
VALUES
    ('ДО «Солнечногорский» Филиала № 7701 Банка ВТБ (ПАО)', '141506, Московская область, г. Солнечногорск, ул. Красная, д. 60',  56.184479, 36.984314, 'Москва', '141506', '09:00-20:00', 1),
    ('ДО «На Баранова» Филиала № 7701 Банка ВТБ (ПАО)', '141500, Московская область, г. Солнечногорск, ул. Баранова, д. 1, 1-й этаж', 56.183239, 36.9757, 'Москва', '141500', '09:00-18:00', 2),
    ('ДО «Лобня» Филиала № 7701 Банка ВТБ (ПАО)', '141730, Московская область, г. Лобня, ул. Ленина, д. 9', 56.184479, 36.984314, 'Москва', '141730', '10:00-19:00', 2),
    ('ДО «На Баранова» Филиала № 7701 Банка ВТБ (ПАО)', '141500, Московская область, г. Солнечногорск, ул. Баранова, д. 1, 1-й этаж', 56.183239, 36.9757, 'Москва', '141500', '09:00-18:00', 4),
    ('ДО «Лобня» Филиала № 7701 Банка ВТБ (ПАО)', '141730, Московская область, г. Лобня, ул. Ленина, д. 9', 56.012386, 37.482059, 'Москва', '141730', '10:00-19:00', 1),
    ('ДО «Черноголовский» Филиала № 7701 Банка ВТБ (ПАО)', '142432, Московская область, г. Черноголовка, пр-д Строителей, д. 1б', 56.011509, 38.377728, 'Москва', '142432', '10:00-19:00', 2),
    ('ДО «Пушкинский» Филиала № 7701 Банка ВТБ (ПАО)', '141207, Московская область, г. Пушкино, ул. Тургенева, д. 24, пом. 018', 51.9876, 3.5678, 'Москва', '141207', '09:00-18:00', 1),
    ('ДО «Черноголовский» Филиала № 7701 Банка ВТБ (ПАО)', '142432, Московская область, г. Черноголовка, пр-д Строителей, д. 1б',  56.011509, 38.377728, 'Москва', '142432', '10:00-19:00', 3),
    ('ДО «Пушкинский» Филиала № 7701 Банка ВТБ (ПАО)','141207, Московская область, г. Пушкино, ул. Тургенева, д. 24, пом. 018' ,51.9876, 3.5678, 'Москва', '141207', '08:30-16:30', 4),
    ('ДО ЦИК «Пушкино» Филиала № 7701 Банка ВТБ (ПАО)', '141200, Московская область, г. Пушкино, ул. Чехова, д. 14а', 56.008335, 37.851467, 'Москва', '141200', '09:00-18:00', 3);


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

-- генератор случайных чисел для булевых значений
INSERT INTO office_filters (office_id, ramp_having, cash_return, pickup_locations, retail_auto_lending)
VALUES (1, true, false, true, true),
       (2, false, true, false, true),
       (3, true, true, false, false),
       (4, false, false, true, true),
       (5, true, false, false, true),
       (6, false, false, true, false),
       (7, true, false, true, true),
       (8, false, false, true, true),
       (9, true, true, true, true),
       (10, false, true, true, true);


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

-- Генерация случайных чисел от 0 до 100 для каждого столбца hourX
INSERT INTO workload (office_id, hour0, hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18, hour19, hour20, hour21, hour22, hour23)
VALUES (1, 87, 41, 63, 98, 22, 7, 32, 12, 54, 90, 68, 2, 76, 36, 49, 81, 29, 59, 70, 8, 45, 17, 93, 60),
       (2, 87, 41, 63, 98, 22, 7, 32, 12, 54, 90, 68, 2, 76, 36, 49, 81, 29, 59, 70, 8, 45, 17, 93, 60),
       (3, 15, 25, 38, 70, 9, 56, 84, 3, 42, 65, 72, 27, 48, 6, 61, 31, 19, 37, 99, 73, 51, 14, 94, 88),
       (4, 74, 64, 46, 16, 53, 43, 85, 47, 30, 62, 1, 26, 78, 4, 91, 20, 11, 58, 50, 35, 79, 52, 66, 21),
       (5, 10, 80, 5, 89, 67, 95, 13, 33, 57, 39, 23, 86, 92, 28, 69, 71, 75, 40, 55, 34, 0, 44, 82, 24),
       (6, 51, 28, 96, 62, 32, 77, 9, 15, 36, 74, 81, 17, 46, 4, 60, 25, 13, 83, 21, 63, 42, 57, 71, 1),
       (7, 91, 64, 47, 68, 41, 26, 70, 14, 38, 50, 53, 85, 19, 59, 73, 58, 45, 8, 35, 86, 52, 2, 7, 6),
       (8, 90, 75, 49, 61, 18, 31, 99, 29, 54, 48, 80, 43, 67, 40, 22, 3, 72, 30, 20, 55, 37, 16, 12, 66),
       (9, 94, 84, 27, 5, 76, 10, 69, 33, 65, 79, 95, 56, 89, 23, 78, 98, 2, 66, 44, 1, 15, 50, 42, 7),
       (10, 37, 74, 88, 57, 24, 61, 64, 14, 45, 6, 95, 26, 53, 79, 39, 32, 41, 52, 13, 51, 80, 11, 81, 18);


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

INSERT INTO atms (address, bnkcd, code, latitude, longitude, working_hours)
VALUES
    ('ул. Богородский Вал, д. 6, корп. 1', 'Sd23rT', '2343', 55.802432, 37.704547, '09:00-17:00'),
    ('ул. Нижняя Красносельская, д. 43', '34Rt4', '5423', 51.4321, 3.8765, '10:00-18:00');
