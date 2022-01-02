package org.model;

public class Staff {
    String staff_id;
    String staff_name;
    String staff_account;
    String staff_password;
    String staff_position;
    String staff_phone;
    String staff_email;

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id='" + staff_id + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", staff_account='" + staff_account + '\'' +
                ", staff_password='" + staff_password + '\'' +
                ", staff_position='" + staff_position + '\'' +
                ", staff_phone='" + staff_phone + '\'' +
                ", staff_email='" + staff_email + '\'' +
                '}';
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_account() {
        return staff_account;
    }

    public void setStaff_account(String staff_account) {
        this.staff_account = staff_account;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public String getStaff_position() {
        return staff_position;
    }

    public void setStaff_position(String staff_position) {
        this.staff_position = staff_position;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }
}
