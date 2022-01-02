package org.model;

public class Infrastructure {
    String facility_id;
    String facility_name;
    String facility_state;
    String facility_type;
    String facility_remark;

    @Override
    public String toString() {
        return "Infrastructure{" +
                "facility_id='" + facility_id + '\'' +
                ", facility_name='" + facility_name + '\'' +
                ", facility_state='" + facility_state + '\'' +
                ", facility_type='" + facility_type + '\'' +
                ", facility_remark='" + facility_remark + '\'' +
                '}';
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_state() {
        return facility_state;
    }

    public void setFacility_state(String facility_state) {
        this.facility_state = facility_state;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getFacility_remark() {
        return facility_remark;
    }

    public void setFacility_remark(String facility_remark) {
        this.facility_remark = facility_remark;
    }
}
