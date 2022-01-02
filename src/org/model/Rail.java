package org.model;

public class Rail {
    String rail_id;
    String rail_name;
    String rail_grade;
    String rail_gauge;
    String rail_type;
    String rail_length;
    String rail_subgrade;
    String rail_position;
    String rail_electrification;
    String rail_remark;

    @Override
    public String toString() {
        return "Rail{" +
                "rail_id='" + rail_id + '\'' +
                ", rail_name='" + rail_name + '\'' +
                ", rail_grade='" + rail_grade + '\'' +
                ", rail_gauge='" + rail_gauge + '\'' +
                ", rail_type='" + rail_type + '\'' +
                ", rail_length='" + rail_length + '\'' +
                ", rail_subgrade='" + rail_subgrade + '\'' +
                ", rail_position='" + rail_position + '\'' +
                ", railelectrification='" + rail_electrification + '\'' +
                ", rail_remark='" + rail_remark + '\'' +
                '}';
    }

    public String getRail_id() {
        return rail_id;
    }

    public void setRail_id(String rail_id) {
        this.rail_id = rail_id;
    }

    public String getRail_name() {
        return rail_name;
    }

    public void setRail_name(String rail_name) {
        this.rail_name = rail_name;
    }

    public String getRail_grade() {
        return rail_grade;
    }

    public void setRail_grade(String rail_grade) {
        this.rail_grade = rail_grade;
    }

    public String getRail_gauge() {
        return rail_gauge;
    }

    public void setRail_gauge(String rail_gauge) {
        this.rail_gauge = rail_gauge;
    }

    public String getRail_type() {
        return rail_type;
    }

    public void setRail_type(String rail_type) {
        this.rail_type = rail_type;
    }

    public String getRail_length() {
        return rail_length;
    }

    public void setRail_length(String rail_length) {
        this.rail_length = rail_length;
    }

    public String getRail_subgrade() {
        return rail_subgrade;
    }

    public void setRail_subgrade(String rail_subgrade) {
        this.rail_subgrade = rail_subgrade;
    }

    public String getRail_position() {
        return rail_position;
    }

    public void setRail_position(String rail_position) {
        this.rail_position = rail_position;
    }

    public String getRail_electrification() {
        return rail_electrification;
    }

    public void setRail_electrification(String rail_electrification) {
        this.rail_electrification = rail_electrification;
    }

    public String getRail_remark() {
        return rail_remark;
    }

    public void setRail_remark(String rail_remark) {
        this.rail_remark = rail_remark;
    }
}
