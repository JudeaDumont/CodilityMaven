package quizSolutions.java.databaseTransactionModule;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserServiceNoSpring {
    public void updatePassword(Integer userId, String newPassword) {
        Connection conn = null;
        PreparedStatement updateUserStmt = null;
        PreparedStatement insertHistoryStmt = null;

        try {
            conn = DatabaseUtil.getConnection();
            conn.setAutoCommit(false);

            // Fetch current password
            String fetchPasswordSQL = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement fetchPasswordStmt = conn.prepareStatement(fetchPasswordSQL);
            fetchPasswordStmt.setInt(1, userId);
            ResultSet rs = fetchPasswordStmt.executeQuery();
            if (!rs.next()) {
                throw new RuntimeException("User not found");
            }
            String currentPassword = rs.getString("password");
            log.info("Fetched current password for user ID: {}", userId);

            // Insert into password history
            String insertHistorySQL = "INSERT INTO password_history (user_id, old_password) VALUES (?, ?)";
            insertHistoryStmt = conn.prepareStatement(insertHistorySQL);
            insertHistoryStmt.setInt(1, userId);
            insertHistoryStmt.setString(2, currentPassword);
            insertHistoryStmt.executeUpdate();
            log.info("Inserted password history for user ID: {}", userId);

            // Update user password
            String updateUserSQL = "UPDATE users SET password = ? WHERE user_id = ?";
            updateUserStmt = conn.prepareStatement(updateUserSQL);
            updateUserStmt.setString(1, newPassword);
            updateUserStmt.setInt(2, userId);
            updateUserStmt.executeUpdate();
            log.info("Updated password for user ID: {}", userId);

            // Commit transaction
            conn.commit();
            log.info("Password update transaction committed successfully for user ID: {}", userId);

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    log.error("Transaction rolled back due to an error for user ID: {}", userId, e);
                } catch (SQLException ex) {
                    log.error("Error during transaction rollback for user ID: {}", userId, ex);
                }
            } else {
                log.error("Error during database operation for user ID: {}", userId, e);
            }
        } finally {
            // Close resources
            try {
                if (updateUserStmt != null) updateUserStmt.close();
                if (insertHistoryStmt != null) insertHistoryStmt.close();
                if (conn != null) conn.close();
                log.debug("Database resources closed successfully.");
            } catch (SQLException e) {
                log.error("Error closing database resources for user ID: {}", userId, e);
            }
        }
    }
}
