package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String mobilePhone;
  private final String email;
  private final String bMonth;
  private final String bDay;
  private final String bYear;

  public ContactData(String firstName, String lastName, String nickname, String title, String company, String address, String mobilePhone, String email, String bMonth, String bDay, String bYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.email = email;
    this.bMonth = bMonth;
    this.bDay = bDay;
    this.bYear = bYear;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbDay() {
    return bDay;
  }

  public String getbYear() {
    return bYear;
  }
}
