package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneBookTest {
    private PhoneBook testPhoneBook;
    @BeforeEach
    void init() {
        testPhoneBook = new PhoneBook();
        testPhoneBook.add("Abonent 0", "(495) 111-22-33");
    }
    @Test
    void addMainTest() {
        testPhoneBook.add("Abonent 1", "(495) 444-55-66");
        assertEquals(3, testPhoneBook.add("Abonent 2", "(495) 777-88-99"));
    }

    @Test
    void addDoubleTest() {
        testPhoneBook.add("Abonent 1", "(495) 444-55-66");
        assertEquals(2, testPhoneBook.add("Abonent 1", "(495) 777-88-99"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void addNullOrEmptyNameTest(String name) {
        assertEquals(1, testPhoneBook.add(name, "(495) 777-88-99"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void addNullOrEmptyPhoneTest(String phone) {
        assertEquals(1, testPhoneBook.add("Abonent 1", phone));
    }

    @Test
    void findByNumberMainTest() {
        assertTrue(testPhoneBook.findByNumber("(495) 111-22-33").equals("Abonent 0"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void findByNumberNullOrEmptyTest(String phone) {
        assertTrue(testPhoneBook.findByNumber(phone).equals("Укажите номер телефона."));
    }
}