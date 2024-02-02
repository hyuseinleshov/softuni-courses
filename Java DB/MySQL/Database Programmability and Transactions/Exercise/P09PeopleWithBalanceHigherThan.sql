USE soft_uni;

DELIMITER //

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(IN p_balance_threshold DECIMAL(10, 2))
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders ah
	JOIN accounts a ON ah.id = a.account_holder_id
	GROUP BY a.account_holder_id
    HAVING SUM(a.balance) > p_balance_threshold
	ORDER BY a.account_holder_id;
END //

DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);