insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'interior', 'Sièges cuir');
insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'interior', 'Volant Alcantara');
insert into equipment (id, type, label) values (equipment_seq_id.nextval, 'comfort', 'Suspensions adaptables');


insert into client (id, last_name, first_name, user_name, email) values (client_seq_id.nextval, 'Redford', 'Robert', 'Bob92', 'bob@gmail.com');

insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-01T12:45:30', 92300, 'Renault', 'Clio', 1990, 'Manuelle', 'Bleu', false, 'description voiture', 5000,1);
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-02T12:45:30', 75019, 'BMW', 'Série 2', 1990, 'Manuelle', 'Bleu', false, 'description voiture 2', 10000,1);
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 140000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 130000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 120000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 110000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 100000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 90000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 80000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 70000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 60000,1 );
insert into offer (id, date, postal_code, car_brand, car_model, year, gearbox, outer_color, four_wheel_drive, description, price, client_id)
    values (offer_seq_id.nextval, '2020-02-03T12:45:30', 59001, 'Ferrari', 'Testarossa', 1990, 'Manuelle', 'Bleu', false, 'description voiture 3', 50000,1 );

insert into offers_equipments (offer_id, equipment_id) values (1, 1);
insert into offers_equipments (offer_id, equipment_id) values (1, 2);
insert into offers_equipments (offer_id, equipment_id) values (1, 3);


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

