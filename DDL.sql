CREATE TABLE SALES_LOCATION(
	Location_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	Location_Description varchar(20) NOT NULL,
	Location_City varchar(20),
	Location_State	varchar(20),
	Location_PostCode varchar(5) ,
	PRIMARY KEY(Location_ID),
);

CREATE TABLE CASHIER(
	Cashier_ID varchar(5) NOT NULL,
	Location_ID integer NOT NULL,
	Cashier_FirstName varchar(20) NOT NULL,
	Cashier_LastName varchar(20) NOT NULL,
	Cashier_Gender varchar(1) CHECK(Cashier_Gender IN('F','M')) NOT NULL,
	Counter_Num varchar(1) NOT NULL,
	PRIMARY KEY(Cashier_ID,Location_ID),
	FOREIGN KEY(Location_ID) REFERENCES SALES_LOCATION ON DELETE CASCADE,
);

CREATE TABLE CUSTOMER(
	Customer_ID varchar(6) NOT NULL,
	Customer_FirstName varchar(20) NOT NULL,
	Customer_LastName varchar(20) NOT NULL,
	Customer_Age integer,
	Customer_Gender varchar(1) CHECK(Customer_Gender IN('F','M')) ,
	Customer_Phone varchar(11),
	Cashier_ID varchar(5) ,
	Location_ID integer,
	PRIMARY KEY(Customer_ID),
	FOREIGN KEY(Cashier_ID,Location_ID) REFERENCES CASHIER ON DELETE SET NULL
);

CREATE TABLE AREA(
	Area_Code varchar(3) NOT NULL,
	Area_Description varchar(10) NOT NULL, 
	Price decimal(5,2) NOT NULL, 
	PRIMARY KEY(Area_Code),
);

CREATE TABLE SEAT(
	Seat_No varchar(6) NOT NULL,
	Area_Code varchar(3) NOT NULL,
	Seat_Row varchar(2) NOT NULL,
	Seat_Col varchar(2) NOT NULL,
	PRIMARY KEY(Seat_No,Area_Code),
	FOREIGN KEY(Area_Code) REFERENCES AREA ON DELETE RESTRICT,
);

CREATE TABLE VENUE(
	Venue_Code varchar(3) NOT NULL,
	Venue_Description varchar(20) NOT NULL,
	Venue_City varchar(20),
	Venue_State varchar(20),
	Venue_PostCode varchar(5),
	PRIMARY KEY(Venue_Code),
);

CREATE TABLE CONCERT_SHOWING(
	Concert_Code varchar(7) NOT NULL,
	Concert_Title varchar(20) NOT NULL,
	Concert_Date date NOT NULL,
	Concert_StartTime time NOT NULL,
	Concert_EndTime time NOT NULL, 
	Venue_Code varchar(3) NOT NULL,
	PRIMARY KEY(Concert_Code),
	FOREIGN KEY(Venue_Code) REFERENCES VENUE ON DELETE RESTRICT,
);

CREATE TABLE TICKET(
	Trans_No varchar(8) NOT NULL,
	Concert_Code varchar(7) NOT NULL,
	Seat_No varchar(6) NOT NULL,
	Area_Code varchar(3) NOT NULL,
	Customer_ID varchar(6) NOT NULL,
	Purchased_Date date NOT NULL,
	Purchased_Time time NOT NULL,
	Ticket_Type varchar(20) CHECK(Ticket_Type IN('Adult','Children')) NOT NULL,
	Ticket_Refundable varchar(20) DEFAULT'Available',
	Discounted_Price decimal(5,2),
	PRIMARY KEY(Trans_No),
	FOREIGN KEY(Concert_Code) REFERENCES CONCERT_SHOWING ON DELETE CASCADE,
	FOREIGN KEY(Seat_No,Area_Code) REFERENCES SEAT ON DELETE RESTRICT,
	FOREIGN KEY(Customer_ID) REFERENCES CUSTOMER ON DELETE RESTRICT,
);

CREATE INDEX idx_cashier_location_id ON CASHIER(Location_ID);

CREATE INDEX idx_customer_cashier_location_id ON CUSTOMER(Cashier_ID, Location_ID);
CREATE INDEX idx_customer_lastname ON CUSTOMER(Customer_LastName);
CREATE INDEX idx_customer_phone ON CUSTOMER(Customer_Phone);

CREATE INDEX idx_seat_area_code ON SEAT(Area_Code);

CREATE INDEX idx_concert_showing_venue_code ON CONCERT_SHOWING(Venue_Code);
CREATE INDEX idx_concert_showing_date ON CONCERT_SHOWING(Concert_Date);

CREATE INDEX idx_ticket_concert_code ON TICKET(Concert_Code);
CREATE INDEX idx_ticket_seat_no_area_code ON TICKET(Seat_No, Area_Code);
CREATE INDEX idx_ticket_customer_id ON TICKET(Customer_ID);
CREATE INDEX idx_ticket_purchased_date_time ON TICKET(Purchased_Date, Purchased_Time);




	