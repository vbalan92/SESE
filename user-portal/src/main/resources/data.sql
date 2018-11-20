insert into roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (email, name, password, username) values ('sierzant.kamil@gmail.com','Kamil','$2a$10$/qJjEDTrbKbIFnjJNRIwkuNcjWJffoaKfacVqwFtFDHXfzRgzvQS6','sierzant.kamil@gmail.com');
insert into users (email, name, password, username) values ('abbasulusoy1985@gmail.com','Abbas','$2a$10$jUz8ZM/ZbdURlGw9KaNaKOTZxWv5tJV3ZvXOQd1nWj3I8x4kzczq2','abbasulusoy1985@gmail.com');
insert into users (email, name, password, username) values ('mirunix_tm@yahoo.com','Miru','$2a$10$925i8Ii9XL68CzwE7Hc8KOiDKIXCdRLO3w9OA/8e/HLbXnlntom82','mirunix_tm@yahoo.com');
insert into users (email, name, password, username) values ('balan_vlad92@yahoo.com','Vlad','$2a$10$RxCvqjekQPU8MFSxWbhk7OwgXlkjur9T19alK8.IMGUY7cBIbLHaq','balan_vlad92@yahoo.com');
insert into users (email, name, password, username) values ('user1@mail.com','User1','$2a$10$zQFAYbC53rnHC.jBjCcX2.l4DO6/qUyfu3gQ9dL2HhT5TOqAN34kC','user1@mail.com');
insert into users (email, name, password, username) values ('user2@mail.com','User2','$2a$10$Cwjx0Iq4Jml3bkdWFiu/D.0bZrAbpI/KEAvIh0yTfb.2bRpuf6eOm','user2@mail.com');
insert into users (email, name, password, username) values ('sese18@mail.com','sese18@mail.com','$2a$10$uWLs6BjlD4Hof5AyoonakOWfw5IzVl4WG3t0hrSJyt8YFqAUQHO.q','sese18@mail.com');

insert into user_roles (user_id, role_id) VALUES (1,2);
insert into user_roles (user_id, role_id) VALUES (2,2);
insert into user_roles (user_id, role_id) VALUES (3,2);
insert into user_roles (user_id, role_id) VALUES (4,2);
insert into user_roles (user_id, role_id) VALUES (5,1);
insert into user_roles (user_id, role_id) VALUES (6,1);

insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Das Zimmer befindet sich im Erdgeschoss, hat ein eigens Bad mit Dusche und ein Doppelbett.', '../../../assets/rooms/apartment-bed-chair-189333.jpg','Zimmer 1',1,50,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Dieses Zimmer ist perfekt für 2 Personen, mit einem Doppelbett und eigenes Bad mit Badewanne.', '../../../assets/rooms/apartment-bed-chair-189333.jpg','Zimmer 2',2,60,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Das Zimmer befindet sich im ersten Stock, hat ein eigens Bad mit Dusche und ein Doppelbett.', '../../../assets/rooms/accomodation-bed-hotel-97083.jpg','Zimmer 3',3,70,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Dieses Zimmer ist perfekt für 2 Personen, mit einem Doppelbett und eigenes Bad mit Badewanne.', '../../../assets/rooms/bed-bedroom-ceiling-262048.jpg','Zimmer 4',4,80,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Das Zimmer befindet sich im zweiten Stock, hat ein eigens Bad mit Dusche und ein Doppelbett..', '../../../assets/rooms/bed-bedroom-curtains-26139.jpg','Zimmer 5',5,90,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Dieses Zimmer ist perfekt für 2 Personen, mit einem Doppelbett und eigenes Bad mit Badewanne.', '../../../assets/rooms/apartment-bed-bedroom-271618.jpg','Zimmer 6',6,99,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Das Zimmer befindet sich im dritten Stock, hat ein eigens Bad mit Dusche und ein Doppelbett..', '../../../assets/rooms/bed-bedroom-furniture-279746.jpg','Zimmer 7',7,45,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Dieses Zimmer ist perfekt für 2 Personen, mit einem Doppelbett und eigenes Bad mit Badewanne.', '../../../assets/rooms/accomodation-bed-hotel-97083.jpg','Zimmer 8',8,33,'DZ');
insert into room (CAPACITY, DESCRIPTION, MAIN_PICTURE, NAME,NUMBER, PRICE,TYPE) VALUES (2, 'Dieses Zimmer ist perfekt für 2 Personen, mit einem Doppelbett und eigenes Bad mit Badewanne.', '../../../assets/rooms/apartment-bed-chair-189333.jpg','Zimmer 9',9,54,'DZ');