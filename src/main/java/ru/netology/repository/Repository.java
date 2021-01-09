package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket tiket) {       //добавить
        int leng = tickets.length + 1;
        Ticket[] temp = new Ticket[leng];
        System.arraycopy(tickets, 0, temp, 0, tickets.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = tiket;
        tickets = temp;
    }

    public Ticket[] findAll() {            //получить список
        return tickets;
    }

    public void removeById(int id) {      //удалить
        int leng = tickets.length + 1;
        Ticket[] temp = new Ticket[leng];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                temp[index] = ticket;
                index++;
            }
        }
        tickets = temp;
    }
}
