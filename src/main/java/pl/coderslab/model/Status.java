package pl.coderslab.model;

public class Status {

    private int id=0;
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Status setId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Status setStatus(String status) {
        this.status = status;
        return this;
    }
}

