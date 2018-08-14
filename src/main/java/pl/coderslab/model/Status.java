package pl.coderslab.model;

public class Status {

    private int id;
    private int statusId = -1;
    private String[] StatusState = {"Przyjęty",
            "Zatwierdzone koszty naprawy",
            "W naprawie",
            "Gotowy do odbioru",
            "Rezygnacja" };


    public int getId() {
        return id;
    }


    public Status setStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public Status setStatusState(String[] statusState) {
        StatusState = statusState;
        return this;
    }

    public Status(int statusId) {
        this.statusId = statusId;

    }

    public String getStatusState() {
        return StatusState[statusId];
    }

    public int getStatusId() {
        return statusId;
    }
}
