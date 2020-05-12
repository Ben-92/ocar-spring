-- au premier lancement de l'appli : ddl-auto= create
-- lancements suivants : ddl-auto= update

-- les delete sont à coder que en mode ddl-auto=update, et si nécessaire (si jeu de données à recréer)
-- et si ça ne vient pas à l'encontre de contraintes de la base. Par exemple deleter les roles seuls pose pb
-- si on ne delete pas les role_user
--      delete from roles;


-- pour le premier passage, mettre ddl-auto=create et mettre les requètes d'initialisation de la base comme ci-dessous pour
-- initialiser les roles
--      insert into roles (id, name) values (1, 'ROLE_USER');
--      insert into roles (id, name) values (2, 'ROLE_MODERATOR');
--      insert into roles (id, name) values (3, 'ROLE_ADMIN');

-- pour les passages ddl-auto=update : ordre sql 'bidon' pour les passages en ddl-auto=update. le data.sql ne peut pas être vide
update roles set name = 'ROLE_USER' where id = 1;
--
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'interior', 'Sièges cuir');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'interior', 'Volant Alcantara');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'comfort', 'Suspensions adaptables');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'comfort', 'Suspensions réglables');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'comfort', 'Appuie-têtes réglables');


-- insert into client (id, last_name, first_name, user_name, email) values (client_seq_id.nextval, 'Redford', 'Robert', 'Bob92', 'bob@gmail.com');

-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-01T12:45:30', 92300, 'Renault', 'Clio', 1990, 'Manuelle', 'Bleu', false, 'description voiture', 5000,1);
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-04T12:45:30', 75019, 'BMW', 'Série 2', 1990, 'Manuelle', 'Bleu', false, 'description voiture 2', 10000,1);
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-05T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 140000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-06T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 130000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-07T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 120000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-08T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 110000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-09T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 100000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-10T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 90000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-11T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 80000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-12T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 70000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-13T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 60000,1 );
-- insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
--     values (offer_seq_id.nextval, '2020-02-14T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 50000,1 );



-- insert into offers_equipments (offer_id, equipment_id) values (1, 1);
-- insert into offers_equipments (offer_id, equipment_id) values (1, 2);
-- insert into offers_equipments (offer_id, equipment_id) values (1, 3);
-- insert into offers_equipments (offer_id, equipment_id) values (1, 4);
-- insert into offers_equipments (offer_id, equipment_id) values (1, 5);


-- insert into offer (id, date, postal_code, car_brand, car_model, price, car_id)
--     values (car_ad_seq_id.nextval, '2020-02-01T12:45:30', 92300, 'Renault', 'Clio', 5000, 1);
-- insert into offer (id, date, postal_code, car_brand, car_model, price, car_id)
--     values (car_ad_seq_id.nextval, '2020-02-02T12:45:30', 75019, 'BMW', 'Série 2', 11000, 2);
-- insert into offer (id, date, postal_code, car_brand, car_model, price, car_id)
--     values (car_ad_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 140000, 3);

-- insert into cars_equipments (car_id, equipment_id) values (1, 1);
-- insert into cars_equipments (car_id, equipment_id) values (1, 2);
-- insert into cars_equipments (car_id, equipment_id) values (1, 3);

-- insert into car (id, year, gearbox, outer_color, four_wheel_drive)
--     values (car_seq_id.nextval, '2018', 'Automatique', 'Rouge', false);
-- insert into car (id, year, gearbox, outer_color, four_wheel_drive)
--     values (car_seq_id.nextval, '2016', 'Automatique', 'Bleu', true);
-- insert into car (id, year, gearbox, outer_color, four_wheel_drive)
--     values (car_seq_id.nextval, '2019', 'Manuelle', 'Jaune', false );

