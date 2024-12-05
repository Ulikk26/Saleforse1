package DTO_models;

public class Account {
    String accountName;
    String accountNumber;
    String phone;
    String fax;
    String accountSite;
    String rating;
    String type;
    String industry;
    String annualRevenue;
    String website;
    String tickerSymbol;
    String ownership;
    String employees;
    String parentAccount;

    public Account(String accountName, String accountNumber, String phone, String fax, String accountSite,
                   String rating, String type, String industry, String annualRevenue, String website,
                   String tickerSymbol, String ownership, String employees, String parentAccount) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.phone = phone;
        this.fax = fax;
        this.accountSite = accountSite;
        this.rating = rating;
        this.type = type;
        this.industry = industry;
        this.annualRevenue = annualRevenue;
        this.website = website;
        this.tickerSymbol = tickerSymbol;
        this.ownership = ownership;
        this.employees = employees;
        this.parentAccount = parentAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountSite() {
        return accountSite;
    }

    public void setAccountSite(String accountSite) {
        this.accountSite = accountSite;
    }

    public String getType() {return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }
}
