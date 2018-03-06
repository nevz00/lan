package ru.sarrz.lan.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.email"),
})

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "user_unique_email_idx")})
public class User extends AbstractNameEntity {

    public static final String DELETE = "User.delete";
    public static final String BY_EMAIL = "User.getByEmail";
    public static final String ALL_SORTED = "User.getAllSorted";



    @Column(name = "firstName",nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "lastName",nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "position",nullable = false)
    @NotBlank
    private String position;

    @NotBlank
    @Column(name = "telephoneInner",nullable = false)
    private String telephoneInner;

    @Column(name = "mobilePhone",nullable = false)
    private String mobilePhone;

    @Column(name = "password",nullable = false)
    @NotBlank
    private String password;

    @Column(name = "email",nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "autoNumber")
    private String autoNumber;

    @Column(name = "firstName",nullable = false)
    @NotNull
    private LocalDate date;


    public User(){
    }

    public User(User u){
        this(u.getId(),u.getFirstName(),u.getLastName(),u.getPosition(),u.getTelephoneInner(),u.getMobilePhone(),u.getPassword(),u.getEmail(),u.getAutoNumber(),u.getDate());

    }

    public User(Integer id, String firstName, String lastName, String position, String telephoneInner, String mobilePhone, String password, String email, String autoNumber, LocalDate date) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.telephoneInner = telephoneInner;
        this.mobilePhone = mobilePhone;
        this.password=password;
        this.email = email;
        this.autoNumber = autoNumber;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelephoneInner() {
        return telephoneInner;
    }

    public void setTelephoneInner(String telephoneInner) {
        this.telephoneInner = telephoneInner;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +'\''+
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", telephoneInner='" + telephoneInner + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", autoNumber='" + autoNumber + '\'' +
                ", date=" + date +
                '}';
    }
}
