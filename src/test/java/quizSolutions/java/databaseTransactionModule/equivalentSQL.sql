DELIMITER //

CREATE PROCEDURE update_password(IN userId INT, IN newPassword VARCHAR(100))
BEGIN
    DECLARE currentPassword VARCHAR(100);

START TRANSACTION;

-- Fetch current password
SELECT password INTO currentPassword
FROM users
WHERE user_id = userId;

-- Check if the user exists
IF currentPassword IS NOT NULL THEN
        -- Insert into password history
        INSERT INTO password_history (user_id, old_password)
        VALUES (userId, currentPassword);

        -- Update user password
UPDATE users
SET password = newPassword
WHERE user_id = userId;

COMMIT;
ELSE
        ROLLBACK;
END IF;
END //

DELIMITER ;
