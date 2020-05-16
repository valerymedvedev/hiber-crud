package com.valeriimedvedev.demo.spring4.hiber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {

    private String hobbyId;
    private Set<Contact> contacts = new HashSet<>();

    @Id
    @Column(name = "HOBBY_ID")
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "HOBBY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hobby.class.getSimpleName() + "[", "]")
                .add("hobbyId='" + hobbyId + "'")
                .toString();
    }
}
