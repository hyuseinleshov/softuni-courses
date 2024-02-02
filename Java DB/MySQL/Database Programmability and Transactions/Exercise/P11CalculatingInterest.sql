USE soft_uni;

DELIMITER //

CREATE PROCEDURE usp_calculate_future_value_for_account(id INT, interest_rate DECIMAL(10, 4))
BEGIN
	SELECT a.id AS account_id, ah.first_name, ah.last_name, a.balance, ufn_calculate_future_value(a.balance, interest_rate, 5) AS balance_in_5_years
    FROM account_holders ah
    JOIN accounts a ON ah.id = a.account_holder_id
    WHERE a.id = id;
END //

DELIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);

DROP PROCEDURE usp_calculate_future_value_for_account;