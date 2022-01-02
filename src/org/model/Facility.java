package org.model;

public class Facility {
    String equipment_id;
    String equipment_name;
    String equipment_type;
    String equipment_date;
    String equipment_price;

    @Override
    public String toString() {
        return "Facility{" +
                "equipment_id='" + equipment_id + '\'' +
                ", equipment_name='" + equipment_name + '\'' +
                ", equipment_type='" + equipment_type + '\'' +
                ", equipment_date='" + equipment_date + '\'' +
                ", equipment_price='" + equipment_price + '\'' +
                '}';
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(String equipment_type) {
        this.equipment_type = equipment_type;
    }

    public String getEquipment_date() {
        return equipment_date;
    }

    public void setEquipment_date(String equipment_date) {
        this.equipment_date = equipment_date;
    }

    public String getEquipment_price() {
        return equipment_price;
    }

    public void setEquipment_price(String equipment_price) {
        this.equipment_price = equipment_price;
    }
}
