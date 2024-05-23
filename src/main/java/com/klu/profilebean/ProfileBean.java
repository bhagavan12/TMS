package com.klu.profilebean;

import com.klu.tms.connection.DataConnect;
import com.klu.tms.loginbean.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ManagedBean
@SessionScoped
public class ProfileBean implements Serializable {
    private String email;
   	private String fname;
    private String lname;
    private String phone;
    private boolean editMode;

    public ProfileBean() {
        // Retrieve the logged-in user's email from the session
        email = SessionUtils.getEmails();

        // Initialize the profile data based on the logged-in user's email
        retrieveProfileData();

        // Set the initial edit mode to false
        editMode = false;
    }

    public void retrieveProfileData() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DataConnect.getConnection();

            String sql = "SELECT fname, lname, email, phone FROM vsignup WHERE email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                email = resultSet.getString("email");
                phone = resultSet.getString("phone");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            DataConnect.close(resultSet);
            DataConnect.close(statement);
            DataConnect.close(connection);
        }
    }


    public void toggleEditMode() {
        editMode = !editMode;
    }

    public void updateProfile() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DataConnect.getConnection();

            String sql = "UPDATE vsignup SET fname = ?, lname = ?, phone = ? WHERE email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, phone);
            statement.setString(4, email);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                toggleEditMode();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            DataConnect.close(statement);
            DataConnect.close(connection);
        }
     // Set edit mode to false after updating the profile
        editMode = false;
    }


    // Getters and Setters for the profile properties
    // ...

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEditMode() {
        return editMode;
    }
    public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }
}
