package com.example;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.jsonparsing.Json;
import com.jsonparsing.Ticket;
import com.jsonparsing.Tickets;

public class Main {
    public static void main(String[] args) {
        String path = "/home/localhost/tickets.json";
    
        try {
            Tickets tickets = Json.serializeFromJson(path);

            HashMap<String, Duration> minValues = new HashMap<>();
            ArrayList<Integer> prices = new ArrayList<>();

            for(Ticket ticket : tickets.getTickets()){
                if(ticket.getOrigin().equals("VVO") && ticket.getDestination().equals("TLV")){
                    prices.add(ticket.getPrice());
                    if(minValues.get(ticket.getCarrier()) != null){
                        if(ticket.getDuration().compareTo(minValues.get(ticket.getCarrier())) < 0){
                            minValues.replace(ticket.getCarrier(), ticket.getDuration());
                        }
                    }else{
                        minValues.put(ticket.getCarrier(), ticket.getDuration());
                    }
                }
            }

            for(Map.Entry<String, Duration> entry : minValues.entrySet()){
                System.out.println(String.format("Carrier: %s, %d Hours, %02d Minutes, %02d Seconds", entry.getKey(), entry.getValue().toHours(), entry.getValue().toMinutesPart(), entry.getValue().toSecondsPart()));
            }

            Integer sum = 0;

            for(Integer i : prices){
                sum += i;
            }
            double avg_price = (double)sum / (double)prices.size();
            Collections.sort(prices);

            Integer median = (prices.get(prices.size() / 2 - 1) + prices.get(prices.size() / 2)) / 2;

            System.out.println(avg_price - median);

        } catch (IOException e) {
            System.out.printf("An IOException occurred: %s", e.toString());
        }
    }
}