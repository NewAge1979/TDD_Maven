package org.example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> myPhoneBook = new HashMap<>();
    public int add(String name, String phone) {
        if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
            myPhoneBook.put(name, phone);
        }
        return myPhoneBook.size();
    }

    public String findByNumber(String phone) {
        return null;
    }
}