package org.example.datatest.utils;

import com.github.javafaker.Faker;

public class FakeDataUtils {
    private static final Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getFullName() {
        return faker.name().fullName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }

    public static String getPhone() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }
}

