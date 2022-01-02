package org.model;

public class Mission {
    String task_id;
    String task_content;
    String task_date;

    @Override
    public String toString() {
        return "Mission{" +
                "task_id='" + task_id + '\'' +
                ", task_content='" + task_content + '\'' +
                ", task_date='" + task_date + '\'' +
                '}';
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }

    public String getTask_date() {
        return task_date;
    }

    public void setTask_date(String task_date) {
        this.task_date = task_date;
    }
}
