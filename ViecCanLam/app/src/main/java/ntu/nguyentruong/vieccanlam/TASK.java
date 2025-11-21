package ntu.nguyentruong.vieccanlam;

import java.util.HashMap;

public class TASK {
    String name, message, date, priority;

    public TASK() {
    }

    public TASK(String name, String message, String date, String priority) {
        this.name = name;
        this.message = message;
        this.date = date;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public HashMap<String,String> toFireBaseObject(){
        HashMap<String,String> taskObject = new HashMap<String,String>();
        taskObject.put("name",name);
        taskObject.put("date",date);
        taskObject.put("message",message);
        taskObject.put("priority",priority);
        return taskObject;
    }
}
