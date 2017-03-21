package wrappers;

import java.util.ArrayList;
import java.util.List;

public class TicketsWrapper {

    private List<TicketWrapper> tickets;

    public TicketsWrapper() {
        this.tickets = new ArrayList<TicketWrapper>();
    }

    public List<TicketWrapper> getTickets() {
        return this.tickets;
    }

    public boolean isEmpty() {
        return this.tickets.isEmpty();
    }

    public TicketWrapper getFirstTicket() {
        if (this.tickets.isEmpty())
            return new TicketWrapper();

        return this.tickets.get(0);
    }

    public boolean userHasTicketsByMobile(long mobile) {
        if (!this.isEmpty())
            for (TicketWrapper ticket : this.tickets)
                if (ticket.getUser().getMobile() == mobile)
                    return true;

        return false;
    }

    public void addTicketWrapper(TicketWrapper ticket) {
        this.tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "TicketsWrapper [tickets=" + tickets + "]";
    }

}
