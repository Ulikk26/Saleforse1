package DTO_models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String accountName;
    private String accountNumber;
    private String phone;
    private String fax;
    private String accountSite;
    private String rating;
    private String type;
    private String industry;
    private String annualRevenue;
    private String website;
    private String tickerSymbol;
    private String ownership;
    private String employees;
    private String parentAccount;
}
