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

-- pour le premier passage, mettre ddl-auto=create et mettre les requètes d'initialisation de la base comme ci-dessous pour
-- initialiser les equipments
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Aide parking');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Attelage');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Echappement inox');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Echappement sport');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Freins céramique');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Galerie');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Pack hiver');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Peinture métallisée');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Radar de recul');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Extérieur', 'Rétroviseurs rabbatables');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', '4 vitres électriques');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Banquette rabattable');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Boite séquentielle');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Climatisation');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Chargeur 6 CD');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Pack confort');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Prise 12 V');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Prise audio USB');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Sièges baquets');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Intérieur', 'Stores');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', '2 airbags');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Affichage tête haute');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Aide au démarrage en côte');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Anti-patinage');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Avertisseur d''angle mort');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Contrôle de pression des pneus');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Extincteur');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Feux automatiques');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Radar anti-collision');
-- insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'Sécurité', 'Suspension pilotée');



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



