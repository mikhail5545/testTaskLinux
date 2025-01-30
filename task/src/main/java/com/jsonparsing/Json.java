package com.jsonparsing;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json{
    private static final ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper(){
        ObjectMapper oMapper = new ObjectMapper();

        return oMapper;
    }

    public static Tickets serializeFromJson(String pathString) throws IOException{
        File jsonFile = new File(pathString);

        Tickets tickets = objectMapper.readValue(jsonFile, Tickets.class);

        return tickets;
    }
}