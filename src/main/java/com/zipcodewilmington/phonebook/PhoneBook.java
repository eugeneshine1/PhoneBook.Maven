package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = new LinkedHashMap<>();
        this.phoneBook.putAll(map);
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());

    }

    public void add(String name, String phoneNumber) {
        this.phoneBook.put(name,Collections.singletonList(phoneNumber));

    }

    public void addAll(String name, String... phoneNumbers) {
        this.phoneBook.put(name,new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        this.phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> reversed : phoneBook.entrySet()){
            if (reversed.getValue().contains(phoneNumber)){
                return reversed.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phoneBook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }

    public Boolean hasEntry(String name, String phoneNumber) {
                                            //not phoneBook.containsValue(phoneNumber);
        if (phoneBook.containsKey(name)&& phoneBook.get(name).contains(phoneNumber)){
            return true;
        } else {
            return null;
        }
    }
}
