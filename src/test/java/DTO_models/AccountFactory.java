package DTO_models;

import com.github.javafaker.Faker;

public class AccountFactory {
    public static Account getAccount(String accountSite, String rating, String type, String industry, String ownership, String parentAccount) {
        Faker faker = new Faker();
        return new Account("Julia " + faker.company().name(),
                faker.number().digits(100),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                accountSite,
                rating,
                type,
                industry,
                faker.number().digit(),
                faker.internet().url(),
                faker.letterify("ABCD"),
                ownership,
                faker.number().digit(),
                parentAccount);

    }

}
