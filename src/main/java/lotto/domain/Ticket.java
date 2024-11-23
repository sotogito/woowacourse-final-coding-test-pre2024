package lotto.domain;

public class Ticket {
    private final static int ONE_LOTTO_PRICE = 1000;
    private int ticketNumber;

    public Ticket() {
    }

    public boolean isEnd() {
        return ticketNumber == 0;
    }

    public void useTicket() {
        ticketNumber--;
    }

    public void setTicketNumber(final int purchaseAmount) {
        this.ticketNumber = purchaseAmount / ONE_LOTTO_PRICE;
    }

}
