package sample;

import java.time.LocalDate;

public class Item {
    private String title;
    private Object priority;
    private LocalDate expDate;
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public Object getPriority() {
        return priority;
    }
}
