CREATE TABLE notification_emails (
id INT PRIMARY KEY AUTO_INCREMENT,
recipient INT NOT NULL,
`subject` VARCHAR(2000),
body TEXT
);

DELIMITER //

CREATE TRIGGER tr_insert_record
AFTER INSERT
ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails(recipient, `subject`, body)
    VALUES(NEW.account_id,
    CONCAT('Balance change for account: ', NEW.account_id),
    CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %h:%i:%s %p'), ' your balance was changed from ', ROUND(NEW.old_sum, 0), ' to ', ROUND(NEW.new_sum, 0), '.'));
END //

DELIMITER ;