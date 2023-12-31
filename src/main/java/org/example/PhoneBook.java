package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, String> myPhoneBook = new HashMap<>();

    public int add(String name, String phone) {
        if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
            myPhoneBook.put(name, phone);
        }
        return myPhoneBook.size();
    }

    public String findByNumber(String phone) {
        String result = "Укажите номер телефона.";
        if (phone != null && !phone.isEmpty()) {
            result = myPhoneBook
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))
                    .get(phone);
            if (result == null) {
                result = "Абонент не найден.";
            }
        }
        return result;
    }

    public String findByName(String name) {
        String result = "Укажите имя абонента.";
        if (name != null && !name.isEmpty()) {
            result = myPhoneBook.get(name);
            if (result == null) {
                result = "Абонент не найден.";
            }
        }
        return result;
    }

    public void printAllNames() {
        Map<String, String> outData = new TreeMap<>(myPhoneBook);
        outData.forEach((key, value) -> System.out.println(key));
    }
}