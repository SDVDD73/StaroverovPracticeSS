INSERT INTO usr (id, enable, password, username) VALUES (1, true, '123', 'Петька');
INSERT INTO usr (id, enable, password, username) VALUES (2, true, '123', 'Васька');
INSERT INTO usr (id, enable, password, username) VALUES (3, true, '1', '1');
INSERT INTO usr (id, enable, password, username) VALUES (22, true, '123', 'Илюха');
INSERT INTO usr (id, enable, password, username) VALUES (42, true, '321', 'Петрович');
INSERT INTO usr (id, enable, password, username) VALUES (44, true, '321', 'Гуд');
INSERT INTO usr (id, enable, password, username) VALUES (46, true, '1', 'Андрей');
INSERT INTO usr (id, enable, password, username) VALUES (51, true, '111', 'Оля');

INSERT INTO room (id, enable, room_name) VALUES (4, true, 'Комната 4');
INSERT INTO room (id, enable, room_name) VALUES (3, true, 'Комната 3');
INSERT INTO room (id, enable, room_name) VALUES (7, true, 'Комната 7');
INSERT INTO room (id, enable, room_name) VALUES (6, true, 'Комната 6');
INSERT INTO room (id, enable, room_name) VALUES (5, true, 'Комната 5');
INSERT INTO room (id, enable, room_name) VALUES (2, true, 'Комната 2');
INSERT INTO room (id, enable, room_name) VALUES (1, true, 'Публичная комната');

INSERT INTO roles (id, role_name) VALUES (1, 'USER');
INSERT INTO roles (id, role_name) VALUES (2, 'ADMIN');
INSERT INTO roles (id, role_name) VALUES (3, 'MODERATOR');

INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (4, true, 1, 2, 1);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (5, true, 1, 3, 1);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (6, true, 1, 2, 2);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (7, true, 2, 3, 3);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (9, true, 1, 2, 3);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (38, true, 1, 4, 1);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (39, true, 1, 5, 1);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (40, true, 1, 1, 1);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (41, true, 1, 1, 2);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (42, true, 1, 1, 3);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (43, true, 1, 1, 2);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (45, true, 1, 1, 44);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (47, true, 1, 1, 46);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (48, true, 1, 5, 46);
INSERT INTO room_user_role (id, enable, role_id, room_id, user_id) VALUES (52, true, 1, 1, 51);



