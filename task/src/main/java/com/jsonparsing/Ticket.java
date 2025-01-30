package com.jsonparsing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    private LocalDateTime departure_date_time;
    private LocalDateTime arrival_date_time;

    private Duration duration;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    public String getOrigin() {
        return origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getPrice() {
        return price;
    }

    public int getStops() {
        return stops;
    }

    public LocalDateTime getDeparture_date_time() {
        return departure_date_time;
    }

    public LocalDateTime getArrival_date_time() {
        return arrival_date_time;
    }

    public Duration getDuration(){
        return duration;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void setDeparture_time(String departure_time) {
        if(departure_time.length() == 4){
            departure_time = "0" + departure_time;
        }
        this.departure_time = departure_time;
        setDeparture_date_time();
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setArrival_time(String arrival_time) {
        if(arrival_time.length() == 4){
            arrival_time = "0" + arrival_time;
        }
        this.arrival_time = arrival_time;
        setArrival_date_time();
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public void setDeparture_date_time(){
        this.departure_date_time = LocalDateTime.parse(this.departure_date + " " + this.departure_time, formatter);
    }

    public void setArrival_date_time(){
        this.arrival_date_time = LocalDateTime.parse(this.arrival_date + " " + this.arrival_time, formatter);
        this.duration = calculateDuration();
    }

    @Override
    public String toString(){
        return  "origin: " + origin + "\norigin_name: " + origin_name + "\ndestination: " + destination + "\ndestination_name: " + destination_name + 
                "\ndeparture_date: " + departure_date + "\ndeparture_time: " + departure_time + "\narrival_date: " + arrival_date + "\narrival_time: " + arrival_time +
                "\nduration: " + duration;
    }

    public Duration calculateDuration(){
        Duration _duration = Duration.between(this.departure_date_time, this.arrival_date_time);

        return _duration;
    }
}