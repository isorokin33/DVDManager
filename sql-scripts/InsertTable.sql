USE DVDManager;

INSERT INTO USERS VALUES(1, "Ilya", "Ilya", "$2a$10$SB4WM/yLzZLMgwXXF1Zo0.1SqqKj5vJ1NIMKeWfyRaNByFEe9rMZq", 1);
INSERT INTO USERS VALUES(2, "Andrey", "Andrey", "$2a$10$SB4WM/yLzZLMgwXXF1Zo0.1SqqKj5vJ1NIMKeWfyRaNByFEe9rMZq", 1);
INSERT INTO USERS VALUES(3, "Alex", "Alex", "$2a$10$SB4WM/yLzZLMgwXXF1Zo0.1SqqKj5vJ1NIMKeWfyRaNByFEe9rMZq", 1);
INSERT INTO USERS VALUES(4, "Nikolay", "Nikola", "$2a$10$SB4WM/yLzZLMgwXXF1Zo0.1SqqKj5vJ1NIMKeWfyRaNByFEe9rMZq", 1);
INSERT INTO USERS VALUES(5, "Nikita", "Nik", "$2a$10$SB4WM/yLzZLMgwXXF1Zo0.1SqqKj5vJ1NIMKeWfyRaNByFEe9rMZq", 1);

INSERT INTO DISKS VALUES(1, "Scorpions", "Live In Munich 2012", 1);
INSERT INTO DISKS VALUES(2, "Elton John", "Greatest Hits One Night Only", 1);
INSERT INTO DISKS VALUES(3, "The Beatles", "Let it Be 1970", 1);
INSERT INTO DISKS VALUES(4, "S.T.A.L.K.E.R.", "Shadow of Chernobyl", 1);
INSERT INTO DISKS VALUES(5, "Modern Talking", "The Video", 2);
INSERT INTO DISKS VALUES(6, "C.C. Catch", "The Hits", 2);
INSERT INTO DISKS VALUES(7, "Harry Potter", "Philosopher's Stone", 2);
INSERT INTO DISKS VALUES(8, "Marley and Me", "20th Century Fox", 2);
INSERT INTO DISKS VALUES(9, "FIFA 18", "PC DVD", 3);
INSERT INTO DISKS VALUES(10, "NHL", "Stanley Cup Champions 2007-2008", 3);
INSERT INTO DISKS VALUES(11, "Rocky", "The Undisputed Collection", 3);
INSERT INTO DISKS VALUES(12, "Bloodsport", "Jean-Claude Van Damme", 3);
INSERT INTO DISKS VALUES(13, "Avengers", "Infinity War", 4);
INSERT INTO DISKS VALUES(14, "Star Wars", "Episode VIII", 4);
INSERT INTO DISKS VALUES(15, "The Wizard of Oz", "The Wizard of Oz", 4);
INSERT INTO DISKS VALUES(16, "Jurassic World", "Fallen Kingdom", 4);
INSERT INTO DISKS VALUES(17, "Minecraft", "Mojang", 5);
INSERT INTO DISKS VALUES(18, "Geometry Dash", "RobTop Games", 5);
INSERT INTO DISKS VALUES(19, "Bike Race Pro", "Top Free Games", 5);
INSERT INTO DISKS VALUES(20, "The Amazing Spider-Man", "Gameloft", 5);

INSERT INTO TAKENITEM VALUES(1, 5, '2018-08-08 10:05:00', true);
INSERT INTO TAKENITEM VALUES(2, 11, '2018-08-08 11:25:32', true);
INSERT INTO TAKENITEM VALUES(3, 14, '2018-08-09 21:14:02', true);
INSERT INTO TAKENITEM VALUES(4, 19, '2018-08-10 08:45:51', true);
INSERT INTO TAKENITEM VALUES(5, 4, '2018-08-10 14:14:26', true);