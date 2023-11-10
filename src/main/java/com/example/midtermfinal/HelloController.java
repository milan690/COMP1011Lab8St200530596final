package com.example.demo;

import java.time.LocalDate;

public class Customer {
    public Object getId() {
        return null;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public String getProvince() {
        return null;
    }
}

public class data {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthday;
    private String province;

    public data(int id, String firstName, String lastName, String phone, LocalDate birthday, String province) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setBirthday(birthday);
        setProvince(province);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 2) {
            throw new IllegalArgumentException("First name must not be empty and have a length of at least 2 characters");
        }
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 2) {
            throw new IllegalArgumentException("Last name must not be empty and have a length of at least 2 characters");
        }
        this.lastName = lastName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!Pattern.matches("^\\d{3}-\\d{3}-\\d{4}$", phone)) {
            throw new IllegalArgumentException("Invalid phone number format. It should be in the format '###-###-####'.");
        }
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthday cannot be in the future");
        }
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        String[] validProvinces = {"AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"};
        boolean isValidProvince = false;
        for (String valid : validProvinces) {
            if (valid.equals(province)) {
                isValidProvince = true;
                break;
            }
        }

        if (!isValidProvince) {
            throw new IllegalArgumentException("Invalid province. It should be one of the following: AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT");
        }
        this.province = province;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}package com.example.midtermfinal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}