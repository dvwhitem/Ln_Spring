/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch10.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

/**
 *
 * @author vitaliy
 */
@Entity
@Table(name = "contact_audit")
@Audited
public class ContactAudit implements Auditable<String, Long>, Serializable {

    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<Hobby> hobbies = new HashSet<Hobby>();
    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();

    // Audit fields
    private String createdBy;
    private DateTime createdDate;
    private String lastModifiedBy;
    private DateTime lastModifiedDate;

    @Override
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    @Column(name = "CREATED_DATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(DateTime dt) {
        this.createdDate = dt;
    }

    @Override
    @Column(name = "LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(DateTime dt) {
        this.lastModifiedDate = dt;
    }

    @Override
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "contact_audit_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToMany
    @NotAudited
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @OneToMany(mappedBy = "contact", cascade=CascadeType.ALL, orphanRemoval=true)
    @NotAudited
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    @Override
    @Transient
    public boolean isNew() {
        if (id == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ContactAudit{" + "id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + '}';
    }
    
}
