insert into roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (email, name, password, username) values ('sierzant.kamil@gmail.com','Kamil','$2a$10$/qJjEDTrbKbIFnjJNRIwkuNcjWJffoaKfacVqwFtFDHXfzRgzvQS6','sierzant.kamil@gmail.com');
insert into users (email, name, password, username) values ('abbasulusoy1985@gmail.com','Abbas','$2a$10$jUz8ZM/ZbdURlGw9KaNaKOTZxWv5tJV3ZvXOQd1nWj3I8x4kzczq2','abbasulusoy1985@gmail.com');
insert into users (email, name, password, username) values ('mirunix_tm@yahoo.com','Miru','$2a$10$925i8Ii9XL68CzwE7Hc8KOiDKIXCdRLO3w9OA/8e/HLbXnlntom82','mirunix_tm@yahoo.com');
insert into users (email, name, password, username) values ('balan_vlad92@yahoo.com','Vlad','$2a$10$RxCvqjekQPU8MFSxWbhk7OwgXlkjur9T19alK8.IMGUY7cBIbLHaq','balan_vlad92@yahoo.com');
insert into users (email, name, password, username) values ('user1@mail.com','User1','$2a$10$zQFAYbC53rnHC.jBjCcX2.l4DO6/qUyfu3gQ9dL2HhT5TOqAN34kC','user1@mail.com');
insert into users (email, name, password, username) values ('user2@mail.com','User2','$2a$10$Cwjx0Iq4Jml3bkdWFiu/D.0bZrAbpI/KEAvIh0yTfb.2bRpuf6eOm','user2@mail.com');

insert into user_roles (user_id, role_id) VALUES (1,2);
insert into user_roles (user_id, role_id) VALUES (2,2);
insert into user_roles (user_id, role_id) VALUES (3,2);
insert into user_roles (user_id, role_id) VALUES (4,2);
insert into user_roles (user_id, role_id) VALUES (5,1);
insert into user_roles (user_id, role_id) VALUES (6,1);