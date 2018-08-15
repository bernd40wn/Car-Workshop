package pl.coderslab.model;

public class Status {

    private int id=0;
    private int status = -1;
    private int order_id;

    private String[] StatusState = {"Przyjęty",
            "Zatwierdzone koszty naprawy",
            "W naprawie",
            "Gotowy do odbioru",
            "Rezygnacja"};


    public Status() {
    }

    public Status(int id, int statusId, int order_id) {
        this.id = id;
        this.status = statusId;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public Status setId(int id) {
        this.id = id;
        return this;
    }

    public int getStatusId() {
        return status;
    }

    public Status setStatusId(int statusId) {
        this.status = statusId;
        return this;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Status setOrder_id(int order_id) {
        this.order_id = order_id;
        return this;
    }

    public String getStatusState() {
        return StatusState[status];
    }
}

