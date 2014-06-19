CREATE OR REPLACE FUNCTION getFirstNameById(INT) RETURNS VARCHAR(60)
AS $$
BEGIN 
	RETURN(SELECT first_name FROM contact WHERE contact_id = $1);
END
$$
LANGUAGE 'plpgsql';



