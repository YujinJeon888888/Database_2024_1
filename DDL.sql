CREATE TABLE SALES_LOCATION(
    Location_ID INTEGER NOT NULL AUTO_INCREMENT,
    Location_Description VARCHAR(20) NOT NULL,
    Location_City VARCHAR(20),
    Location_State VARCHAR(20),
    Location_PostCode VARCHAR(5),
    PRIMARY KEY (Location_ID),
    CONSTRAINT Location_Unq UNIQUE (Location_Description),
    INDEX idx_Location_City (Location_City),
    INDEX idx_Location_State (Location_State),
    INDEX idx_Location_PostCode (Location_PostCode)
);

CREATE TABLE CASHIER(
    Cashier_ID VARCHAR(5) NOT NULL,
    Location_ID INTEGER NOT NULL,
    Cashier_FirstName VARCHAR(20) NOT NULL,
    Cashier_LastName VARCHAR(20) NOT NULL,
    Cashier_Gender VARCHAR(1) NOT NULL,
    Counter_Num VARCHAR(1) NOT NULL,
    PRIMARY KEY (Cashier_ID, Location_ID),
    FOREIGN KEY (Location_ID) REFERENCES SALES_LOCATION(Location_ID) ON DELETE CASCADE,
    CONSTRAINT Counter_Unq UNIQUE (Location_ID, Counter_Num),
    CHECK (Cashier_Gender IN ('F', 'M')),
    INDEX idx_Cashier_LastName (Cashier_LastName),
    INDEX idx_Cashier_Gender (Cashier_Gender)
);

CREATE TABLE CUSTOMER(
    Customer_ID VARCHAR(6) NOT NULL,
    Customer_FirstName VARCHAR(20) NOT NULL,
    Customer_LastName VARCHAR(20) NOT NULL,
    Customer_Age INTEGER,
    Customer_Gender VARCHAR(1),
    Customer_Phone VARCHAR(11),
    Cashier_ID VARCHAR(5),
    Location_ID INTEGER,
    PRIMARY KEY (Customer_ID),
    FOREIGN KEY (Cashier_ID, Location_ID) REFERENCES CASHIER(Cashier_ID, Location_ID) ON DELETE SET NULL,
    CHECK (Customer_Gender IN ('F', 'M')),
    INDEX idx_Customer_LastName (Customer_LastName),
    INDEX idx_Customer_Phone (Customer_Phone),
    INDEX idx_Customer_Age (Customer_Age)
);

CREATE TABLE AREA(
    Area_Code VARCHAR(3) NOT NULL,
    Area_Description VARCHAR(10) NOT NULL,
    Price DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (Area_Code),
    CONSTRAINT Area_Unq UNIQUE (Area_Description),
    INDEX idx_Area_Description (Area_Description),
    INDEX idx_Price (Price)
);

CREATE TABLE SEAT(
    Seat_No VARCHAR(6) NOT NULL,
    Area_Code VARCHAR(3) NOT NULL,
    Seat_Row VARCHAR(2) NOT NULL,
    Seat_Col VARCHAR(2) NOT NULL,
    PRIMARY KEY (Seat_No, Area_Code),
    FOREIGN KEY (Area_Code) REFERENCES AREA(Area_Code) ON DELETE RESTRICT,
    CONSTRAINT Seat_Unq UNIQUE (Area_Code, Seat_Row, Seat_Col),
    INDEX idx_Seat_Row (Seat_Row),
    INDEX idx_Seat_Col (Seat_Col)
);

CREATE TABLE VENUE(
    Venue_Code VARCHAR(3) NOT NULL,
    Venue_Description VARCHAR(20) NOT NULL,
    Venue_City VARCHAR(20),
    Venue_State VARCHAR(20),
    Venue_PostCode VARCHAR(5),
    PRIMARY KEY (Venue_Code),
    CONSTRAINT Venue_Unq UNIQUE (Venue_Description),
    INDEX idx_Venue_City (Venue_City),
    INDEX idx_Venue_State (Venue_State),
    INDEX idx_Venue_PostCode (Venue_PostCode)
);

CREATE TABLE CONCERT_SHOWING(
    Concert_Code VARCHAR(7) NOT NULL,
    Concert_Title VARCHAR(20) NOT NULL,
    Concert_Date DATE NOT NULL,
    Concert_StartTime TIME NOT NULL,
    Concert_EndTime TIME NOT NULL,
    Venue_Code VARCHAR(3) NOT NULL,
    PRIMARY KEY (Concert_Code),
    FOREIGN KEY (Venue_Code) REFERENCES VENUE(Venue_Code) ON DELETE RESTRICT,
    CONSTRAINT Concert_Unq UNIQUE (Concert_Date, Venue_Code),
    INDEX idx_Concert_Title (Concert_Title),
    INDEX idx_Concert_Date (Concert_Date)
);

CREATE TABLE TICKET(
    Trans_No VARCHAR(8) NOT NULL,
    Concert_Code VARCHAR(7) NOT NULL,
    Seat_No VARCHAR(6) NOT NULL,
    Area_Code VARCHAR(3) NOT NULL,
    Customer_ID VARCHAR(6) NOT NULL,
    Purchased_Date DATE NOT NULL,
    Purchased_Time TIME NOT NULL,
    Ticket_Type VARCHAR(20) NOT NULL,
    Ticket_Refundable VARCHAR(20) DEFAULT 'Available',
    Discounted_Price DECIMAL(5,2),
    PRIMARY KEY (Trans_No),
    FOREIGN KEY (Concert_Code) REFERENCES CONCERT_SHOWING(Concert_Code) ON DELETE CASCADE,
    FOREIGN KEY (Seat_No, Area_Code) REFERENCES SEAT(Seat_No, Area_Code) ON DELETE RESTRICT,
    FOREIGN KEY (Customer_ID) REFERENCES CUSTOMER(Customer_ID) ON DELETE RESTRICT,
    CONSTRAINT Seaq_Unq UNIQUE (Concert_Code, Seat_No, Area_Code),
    CHECK (Ticket_Type IN ('Adult', 'Children')),
    INDEX idx_Purchased_Date (Purchased_Date),
    INDEX idx_Purchased_Time (Purchased_Time),
    INDEX idx_Ticket_Type (Ticket_Type)
);
