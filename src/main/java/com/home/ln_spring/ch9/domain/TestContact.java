/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch9.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author vitaliy
 */
@Entity
@Table(name = "testcontact")
@NamedQueries({
    @NamedQuery(name = "Contact.findById",
            query = "select distinct c from Contact c "
            + "left join fetch c.contactTelDetails t "
            + "left join fetch c.hobbies h where c.id = :id"),
    @NamedQuery(name = "Contact.findAllWithDetail",
            query = "select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h")
})
public class TestContact implements Serializable {

    private int id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<TestContactTelDetail> contactTelDetails
            = new HashSet<TestContactTelDetail>();
    private Set<TestHobby> hobbies = new HashSet<TestHobby>();

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    public Set<TestHobby> getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(Set<TestHobby> hobbies) {
        this.hobbies = hobbies;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<TestContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(Set<TestContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void addContactTelDetail(TestContactTelDetail contactTelDetail) {
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    public void removeContactTelDetail(TestContactTelDetail contactTelDetail) {
        getContactTelDetails().remove(contactTelDetail);
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "contact_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Contact - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
