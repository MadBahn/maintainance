package org.model;

public class _Record {
    String record_id;
    String record_date;
    String record_content;
    String facility_id;
    String equipment_id;
    String rail_id;

    @Override
    public String toString() {
        return "_Record{" +
                "record_id='" + record_id + '\'' +
                ", record_date='" + record_date + '\'' +
                ", record_content='" + record_content + '\'' +
                ", facility_id='" + facility_id + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                ", rail_id='" + rail_id + '\'' +
                '}';
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getRecord_content() {
        return record_content;
    }

    public void setRecord_content(String record_content) {
        this.record_content = record_content;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getRail_id() {
        return rail_id;
    }

    public void setRail_id(String rail_id) {
        this.rail_id = rail_id;
    }
}
