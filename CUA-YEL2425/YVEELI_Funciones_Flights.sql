-- ************************************************
-- FUNCTION RETURNS THE NUMBER OF AVAILABLE SEATS
-- Function name: yveeli_v2_01_available_seats_int
-- Return type: INTEGER
-- Language: plpgsql
-- Arguments_
	-- Data Type: varchar
	-- Mode: IN
	-- Argument Name: f_flight_code
CREATE OR REPLACE FUNCTION yveeli_01_available_seats_int (
    f_flight_code VARCHAR,
    f_date_of_travel DATE
)
RETURNS INTEGER
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    v_total_seats INTEGER;
    v_sold_tickets INTEGER;
    v_available_seats INTEGER;
BEGIN

    SELECT seats INTO v_total_seats
    FROM flights
    WHERE flight_code = f_flight_code;

    SELECT COUNT(*) INTO v_sold_tickets
    FROM tickets
    WHERE flight_code = f_flight_code
      AND date_of_travel = f_date_of_travel;

    v_available_seats := v_total_seats - v_sold_tickets;

    IF v_available_seats < 0 THEN
        RETURN 0;
    END IF;

    RETURN v_available_seats;
END;
$BODY$;


-- ************************************************
-- FUNCTION RETURNS 'TRUE' IF SEATS ARE AVAILABLE
-- Function name: yveeli_v2_01_available_seats_boolean
-- Return type: INTEGER
-- Language: plpgsql
-- Arguments_
	-- Data Type: varchar
	-- Mode: IN
	-- Argument Name: f_flight_code
CREATE OR REPLACE FUNCTION yveeli_02_available_seats_bool (
    f_flight_code VARCHAR,
    f_date_of_travel DATE
)
RETURNS BOOLEAN
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    v_total_seats INTEGER;
    v_sold_tickets INTEGER;
    v_available_seats INTEGER;
BEGIN

    SELECT seats INTO v_total_seats
    FROM flights
    WHERE flight_code = f_flight_code;

    SELECT COUNT(*) INTO v_sold_tickets
    FROM tickets
    WHERE flight_code = f_flight_code
      AND date_of_travel = f_date_of_travel;

    v_available_seats := v_total_seats - v_sold_tickets;

    IF v_available_seats < 0 THEN
        RETURN FALSE;
    END IF;

    RETURN TRUE;
END;
$BODY$;


-- ************************************************
-- FUNCTION RETURNS 'TRUE' IF TICKET IS ALREADY BOUGHT
-- Function name: v2_yveeli_03_ticket_already_exists
-- Return type: BOOLEAN
-- Language: plpgsql
-- Arguments_
	-- Data Type: date
	-- Mode: IN
	-- Argument Name: f_date_of_travel
	
	-- Data Type: varchar
	-- Mode: IN
	-- Argument Name: f_passportno

CREATE OR REPLACE FUNCTION yveeli_03_ticket_already_exists (f_date_of_travel DATE, f_passportno VARCHAR)
	RETURNS BOOLEAN
	LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    v_ticket_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO v_ticket_count
    FROM tickets
    WHERE date_of_travel = f_date_of_travel
    AND passportno = f_passportno;

    IF v_ticket_count > 0 THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$BODY$;