package com.acarainservices.acarainservices.transaction;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.acarainservices.acarainservices.events.Events;
import com.acarainservices.acarainservices.orders.Orders;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Events events;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @Column(name = "Judul")
    private String judul;

    @Column(name = " Jadwal")
    private Time jadwal;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Time getJadwal() {
        return jadwal;
    }

    public void setJadwal(Time jadwal) {
        this.jadwal = jadwal;
    }

}
