INSERT INTO SALES_LOCATION (Location_Description, Location_City, Location_State, Location_PostCode) VALUES
('IOI Mall', 'Puchong', 'Selangor', '47100'),
('TESCO', 'Puchong', 'Selangor', '47100'),
('Setia Walk', 'Puchong', 'Selangor', '47100'),
('Paradigm', 'Petaling Jaya', 'Selangor', '60000'),
('Mid Valley', 'Kepong', 'Kuala Lumpur', '58000');

INSERT INTO CASHIER (Cashier_ID, Location_ID, Cashier_FirstName, Cashier_LastName, Cashier_Gender, Counter_Num) VALUES
('C0010', 1, 'Justin', 'Ng', 'M', '1'),
('C0011', 1, 'Michelle', 'Hee', 'F', '2'),
('C0012', 2, 'Xyres', 'Tan', 'M', '1'),
('C0013', 2, 'Kevin', 'Lee', 'M', '2'),
('C0014', 3, 'Selina', 'Ho', 'F', '1'),
('C0015', 4, 'Donnie', 'Chan', 'M', '1'),
('C0016', 5, 'Emily', 'Ng', 'F', '1'),
('C0017', 5, 'Sean', 'Chow', 'M', '2'),
('C0018', 5, 'Bob', 'Yee', 'M', '3');

INSERT INTO CUSTOMER (Customer_ID, Customer_FirstName, Customer_LastName, Customer_Age, Customer_Gender, Customer_Phone, Cashier_ID, Location_ID) VALUES
('000007', 'Jane', 'Doe', 22, 'F', '01234567890', 'C0010', 1),
('000008', 'James', 'Smith', 30, 'M', '01456789012', 'C0011', 1),
('000009', 'Emma', 'Johnson', 25, 'F', '03245678901', 'C0011', 1),
('000010', 'Liam', 'Williams', 35, 'M', '01256789034', 'C0012', 2),
('000011', 'Olivia', 'Brown', 28, 'F', '01834567890', 'C0013', 2),
('000012', 'Noah', 'Jones', 40, 'M', '03812345678', 'C0017', 5),
('000013', 'Isabella', 'Garcia', 32, 'F', '03823456789', 'C0017', 5);

INSERT INTO AREA (Area_Code, Area_Description, Price) VALUES
('V1', 'VIP', 600),
('V2', 'VVIP', 700),
('R1', 'ROCK A', 500),
('R2', 'ROCK B', 450),
('N', 'Normal', 200);

INSERT INTO SEAT (Seat_No, Area_Code, Seat_Row, Seat_Col) VALUES
('1', 'V1', '1', '1'),
('2', 'V1', '1', '2'),
('3', 'V1', '1', '3'),
('4', 'V1', '1', '4'),
('5', 'V1', '1', '5'),
('1', 'V2', '1', '1'),
('2', 'V2', '1', '2'),
('3', 'V2', '1', '3'),
('4', 'V2', '1', '4'),
('5', 'V2', '1', '5'),
('1', 'R1', '1', '1'),
('2', 'R1', '1', '2'),
('3', 'R1', '1', '3'),
('1', 'R2', '1', '1'),
('2', 'R2', '1', '2'),
('3', 'R2', '1', '3'),
('4', 'R2', '1', '4'),
('1', 'N', '1', '1'),
('2', 'N', '1', '2'),
('3', 'N', '1', '3');

INSERT INTO VENUE (Venue_Code, Venue_Description, Venue_City, Venue_State, Venue_PostCode) VALUES
('BJ', 'KL Bukit Jalil', 'Sepang', 'Kuala Lumpur', '60000'),
('SM', 'Stadium Merdeka', 'Kepong', 'Kuala Lumpur', '50150'),
('G', 'Genting', 'Puchong', 'Selangor', '50150'),
('SP', 'Sunway Pyramid', 'Subang Jaya', 'Selangor', '47500'),
('TP', 'The Pinnacle', 'Petaling Jaya', 'Selangor', '46200');

INSERT INTO CONCERT_SHOWING (Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code) VALUES
('J', 'Jay Chou Tour', '2017-02-27', '18:00:00', '22:00:00', 'BJ'),
('B', 'Beyond Tour', '2017-02-26', '18:00:00', '22:00:00', 'BJ'),
('G', 'GEM Tour', '2017-02-27', '18:00:00', '22:00:00', 'SM'),
('A', 'Alice Tour', '2017-02-22', '18:00:00', '22:00:00', 'SM'),
('JT', 'Jeff Tan Tour', '2017-03-15', '18:00:00', '22:00:00', 'G'),
('W', 'Lee horm Tour', '2017-03-16', '18:00:00', '22:00:00', 'SM'),
('WW', 'Wee World Tour', '2017-02-07', '18:00:00', '22:00:00', 'SM'),
('JW', 'Jack World Tour', '2017-02-08', '18:00:00', '22:00:00', 'BJ');

INSERT INTO TICKET (Trans_No, Concert_Code, Seat_No, Area_Code, Customer_ID, Purchased_Date, Purchased_Time, Ticket_Type) VALUES
('T1', 'J', '1', 'V1', '000008', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Adult'),
('T2', 'J', '2', 'V1', '000008', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Children'),
('T3', 'J', '1', 'V2', '000009', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Adult'),
('T4', 'G', '1', 'R1', '000009', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Adult'),
('T5', 'G', '2', 'R1', '000009', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Children'),
('T6', 'W', '1', 'R1', '000010', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Adult'),
('T7', 'B', '3', 'R1', '000011', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Children'),
('T8', 'B', '2', 'N', '000012', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Children'),
('T9', 'WW', '1', 'V1', '000013', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Children'),
('T10', 'JW', '1', 'V2', '000010', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Adult');
