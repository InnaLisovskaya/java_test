package ru.stqa.pft.addressbook.models;


import java.util.Objects;

public class ContactData {
  private int id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  public ContactData(String firstName, String lastName, String nickname, String title, String company, String address, String mobilePhone, String email, String bMonth, String bDay, String bYear) {
    this.id = Integer.MAX_VALUE;
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

  public ContactData(int id, String firstName, String lastName, String nickname, String title, String company, String address, String mobilePhone, String email, String bMonth, String bDay, String bYear) {
    this.id = id;
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

  public int getId() { return id; }
}

