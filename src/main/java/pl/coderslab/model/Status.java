package pl.coderslab.model;

public class Status {

    private String[] StatusState = {"Przyjęty",
            "Zatwierdzone koszty naprawy",
            "W naprawie",
            "Gotowy do odbioru",
            "Rezygnacja" };
    private int StatusId = -1;

    public Status(int statusId) {
        StatusId = statusId;
    }

    public String getStatusState() {
        return StatusState[StatusId];
    }

    public int getStatusId() {
        return StatusId;
    }
}
