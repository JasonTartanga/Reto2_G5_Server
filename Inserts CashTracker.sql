INSERT INTO User VALUES ('jason@gmail.com', 'Barakaldo', 'Jason', 'abcd*1234', '688878533', 'CLIENT', '48901');
INSERT INTO User VALUES ('david@gmail.com', 'Arabella', 'David', 'abcd*1234', '123456789', 'ADMIN', '15987');
INSERT INTO User VALUES ('bayron@gmail.com', 'Santutxu', 'Bayron', 'abcd', '987654321', 'CLIENT', '35987');
INSERT INTO User VALUES ('ian@gmail.com', 'Sarriko', 'Ian', 'abcd*1234', '258964731', 'ADMIN', '18765');
INSERT INTO User VALUES ('jessica@gmail.com', 'Astrabudua', 'Jessica', 'abcd*1234', '258964731', 'ADMIN', '48901');
INSERT INTO User VALUES ('markel@gmail.com', 'San Ignacio', 'Markel', '1234', '789648247', 'CLIENT', '97345');


INSERT INTO Account VALUES (1, 69420, '2024-06-08', 'Viaje a madrid en junio', 'EUR', 'Concierto Duki', 'Viaje'); 
INSERT INTO Account VALUES (2, 123456, '2023-07-14', 'Planazooo', 'EUR', 'Casa rual', 'Casa_Compartida'); 
INSERT INTO Account VALUES (3, 33560, '1999-09-21', 'Cuenta del Banco de Bayron Takeo', 'BOB', 'Banco Bayron', 'Otro'); 
INSERT INTO Account VALUES (4, 33560, '2022-12-23', 'Cuenta para gastos discotecas', 'EUR', 'Fiestas', 'Celebracion'); 
INSERT INTO Account VALUES (5, 33560, '2026-09-08', 'Cuenta para los gastos del piso', 'EUR', 'Pisito de solteros', 'Casa_Compartida'); 
INSERT INTO Account VALUES (6, 33560, '2023-10-31', 'Vaya pedazo de otakus', 'JPY', 'Viaje a japon', 'Viaje'); 


INSERT INTO Shared VALUES ('Creador', 1,  'jason@gmail.com');
INSERT INTO Shared VALUES ('Autorizado', 1, 'david@gmail.com');
INSERT INTO Shared VALUES ('Autorizado', 1, 'bayron@gmail.com');

INSERT INTO Shared VALUES ('Creador', 2, 'jason@gmail.com');
INSERT INTO Shared VALUES ('Espectador', 2, 'ian@gmail.com');

INSERT INTO Shared VALUES ('Creador', 3, 'bayron@gmail.com');
INSERT INTO Shared VALUES ('Espectador', 3, 'jessica@gmail.com');

INSERT INTO Shared Values('Autorizado', 4, 'jason@gmail.com');
INSERT INTO Shared Values('Autorizado', 4, 'david@gmail.com');
INSERT INTO Shared Values('Creador', 4, 'bayron@gmail.com');
INSERT INTO Shared Values('Autorizado', 4, 'ian@gmail.com');
INSERT INTO Shared Values('Autorizado', 4, 'markel@gmail.com');

INSERT INTO Shared Values('Autorizado', 5, 'david@gmail.com');
INSERT INTO Shared Values('Creador', 5, 'markel@gmail.com');

INSERT INTO Shared Values('Creador', 6, 'jason@gmail.com');
INSERT INTO Shared Values('Autorizado', 6, 'ian@gmail.com');
INSERT INTO Shared Values('Autorizado', 6, 'markel@gmail.com');



INSERT INTO Expense VALUES ('Punctual', 1, 99, 'Entradas para ver el concierto', '2024-06-08', 'Entradas', 0, 0, 'Indispensable', null, null, 1);
INSERT INTO Expense VALUES ('Punctual', 2, 60, 'Tres asientos de ida y vuelta en ALSA', '2024-06-08', 'Bus', 0, 0, 'Relevante', null, null, 1);
INSERT INTO Expense VALUES ('Punctual', 3, 40, 'Air B&B en las afueras', '2024-06-08', 'Estancia', 0, 0, 'Relevante', null, null, 1);
INSERT INTO Expense VALUES ('Punctual', 4, 24, 'Bayron invita a una ronda', '2024-06-08', 'Bar', 0, 0, 'Prescindible', null, null, 1);

INSERT INTO Expense VALUES ('Punctual', 5, 200, 'Toda la comida necesaria para las dos semanas', '2023-07-14', 'Comida', 0, 0, 'Relevante', null, null, 2);
INSERT INTO Expense VALUES ('Recurrent', 6, 189, 'Alquieler de la casa durante dos semanas', '2023-07-14', 'Alquiler', 0, 0, null, 'Alquiler', 'Semanal', 2);
INSERT INTO Expense VALUES ('Recurrent', 7, 189, 'Agua de la casa durante dos semanas', '2023-07-14', 'Agua', 0, 0, null, 'Agua', 'Semanal', 2);
INSERT INTO Expense VALUES ('Punctual', 8, 125, 'Bebidas para las dos semanas', '2023-07-14', 'Bebidas', 0, 0, 'Poco_Relevante', null, null, 2);
INSERT INTO Expense VALUES ('Punctual', 9, 15, 'Juegos de mesa para divertirnos', '2023-07-14', 'Juegos de mesa', 0, 0, 'Prescindible', null, null, 2);


INSERT INTO Expense VALUES ('Punctual', 10, 14, 'Cena de navidad', '2023-12-23', 'Muerde la pasa', 0, 0, 'Poco_Relevante', null, null, 3);
INSERT INTO Expense VALUES ('Recurrent', 11, 150, 'Alquiler mensual del coche', '1999-09-21', 'Coche', 0, 0, null, 'Alquiler', 'Mensual', 3);
INSERT INTO Expense VALUES ('Recurrent', 12, 12.95, 'Netflix and Chill', '1999-09-21', 'Netfilx', 0, 0, null, 'Suscripcion', 'Mensual', 3);
INSERT INTO Expense VALUES ('Punctual', 13, 14, 'Tenia mucha hambre', '2023-12-01', 'Gose', 0, 0, 'Moderado', null, null, 3);
INSERT INTO Expense VALUES ('Punctual', 14, 14, 'Ropa nueva', '2023-12-18', 'Ropa', 0, 0, 'Prescindible', null, null, 3);

INSERT INTO Expense VALUES ('Punctual', 15, 16, 'Entradas para stage', '2023-09-03', 'Stage', 0, 0, 'Relevante', null, null, 4);
INSERT INTO Expense VALUES ('Punctual', 16, 16, 'Entradas para stage', '2023-07-23', 'Stage', 0, 0, 'Relevante', null, null, 4);
INSERT INTO Expense VALUES ('Punctual', 17, 14, 'Entradas para Moma', '2023-10-13', 'Moma', 0, 0, 'Relevante', null, null, 4);
INSERT INTO Expense VALUES ('Punctual', 18, 12, 'Entradas para Flash', '2023-11-25', 'Flash', 0, 0, 'Relevante', null, null, 4);
INSERT INTO Expense VALUES ('Punctual', 19, 14, 'Entradas para stage', '2023-12-15', 'Back', 0, 0, 'Relevante', null, null, 4);
INSERT INTO Expense VALUES ('Punctual', 20, 16, 'Entradas para stage', '2023-12-28', 'Stage', 0, 0, 'Relevante', null, null, 4);

INSERT INTO Expense VALUES ('Recurrent', 21, 35, 'Factura de la luz', '2026-09-08', 'Luz', 0, 0, null, 'Luz', 'Mensual', 5);
INSERT INTO Expense VALUES ('Recurrent', 22, 37.78, 'Factura del agua', '2026-09-08', 'Luz', 0, 0, null, 'Agua', 'Mensual', 5);
INSERT INTO Expense VALUES ('Recurrent', 23, 24.26, 'Factura del gas', '2026-09-08', 'Gas', 0, 0, null, 'Gas', 'Mensual', 5);
INSERT INTO Expense VALUES ('Recurrent', 24, 420.69, 'Factura del alquiler', '2026-09-08', 'Alquiler', 0, 0, null, 'Alquiler', 'Mensual', 5);
INSERT INTO Expense VALUES ('Recurrent', 25, 25.68, 'Factura de la wifi', '2026-09-08', 'Wifi', 0, 0, null, 'Suscripcion', 'Mensual', 5);
INSERT INTO Expense VALUES ('Punctual', 26, 15, 'Reforma de la cocina', '2026-09-08', 'Reforma', 0, 0, 'Relevante', null, null, 5);
INSERT INTO Expense VALUES ('Punctual', 27, 450.78, 'Comida del mes', '2026-09-08', 'Comida', 0, 0, 'Indispensable', null, null, 5);

INSERT INTO Expense VALUES ('Punctual', 28, 1240, 'Tres tickets de ida y vuelta a japon', '2023-10-31', 'Avion', 0, 0, 'Indispensable', null, null, 6);
INSERT INTO Expense VALUES ('Recurrent', 29, 90, 'Habitacion de hotel en el centro', '2023-10-31', 'Estancia', 0, 0, null, 'Alquiler', 'Diario', 6);
INSERT INTO Expense VALUES ('Punctual', 30, 45, 'Sushi en restaurante tradcional', '2023-10-31', 'Comida', 0, 0, 'Moderado', null, null, 6);
INSERT INTO Expense VALUES ('Recurrent', 31, 15, 'Bono para usar el tren y metro ilimitado', '2023-10-31', 'Movimiento', 0, 0, null, 'Alquiler', 'Diario', 6);	