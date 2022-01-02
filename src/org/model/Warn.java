package org.model;

public class Warn {
    String warn_id;
    String warn_grade;
    String warn_content;
    String warn_validtime;
    String warn_date;

    @Override
    public String toString() {
        return "Warn{" +
                "warn_id='" + warn_id + '\'' +
                ", warn_grade='" + warn_grade + '\'' +
                ", warn_content='" + warn_content + '\'' +
                ", warn_validtime='" + warn_validtime + '\'' +
                ", warn_date='" + warn_date + '\'' +
                '}';
    }

    public String getWarn_id() {
        return warn_id;
    }

    public void setWarn_id(String warn_id) {
        this.warn_id = warn_id;
    }

    public String getWarn_grade() {
        return warn_grade;
    }

    public void setWarn_grade(String warn_grade) {
        this.warn_grade = warn_grade;
    }

    public String getWarn_content() {
        return warn_content;
    }

    public void setWarn_content(String warn_content) {
        this.warn_content = warn_content;
    }

    public String getWarn_validtime() {
        return warn_validtime;
    }

    public void setWarn_validtime(String warn_validtime) {
        this.warn_validtime = warn_validtime;
    }

    public String getWarn_date() {
        return warn_date;
    }

    public void setWarn_date(String warn_date) {
        this.warn_date = warn_date;
    }
}
