package com.clientreview.dbconnection;

import java.sql.*;

public class DBUtils {

    public static String getLatestOtp() {
        String otp = null;

        // Replace with your actual connection details
        String url = "jdbc:sqlserver://uatfincart.database.windows.net";
        String user = "FinSelIntern";
        String password = "Finrf6$^7#$3FD67*54#6(75$g";

        // MySQL syntax: use LIMIT instead of TOP
        String query = "SELECT otpCode FROM fin_Otp_Authenticate ORDER BY 1 DESC LIMIT 1";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                otp = rs.getString("otp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return otp;
    }
}
