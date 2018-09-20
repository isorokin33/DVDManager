package com.isorokin.dvdmanager.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = "LOGIN"),
        @UniqueConstraint(columnNames = "PASSWORD") })
public class User implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -3531426625808976964L;

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="LOGIN")
    private String login;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="FULL_NAME")
    private String fullName;

    @Column(name="ACTIVE")
    private int active;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    private Set<Disk> disks = new HashSet<Disk>();

    @OneToMany(mappedBy = "pk.user", cascade=CascadeType.ALL)
    private Set<TakenItem> takenItems = new HashSet<TakenItem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Disk> getDisks() {
        return disks;
    }

    public void setDisks(Set<Disk> disks) {
        this.disks = disks;
    }

    public Set<TakenItem> getTakenItems() {
        return takenItems;
    }

    public void setTakenItems(Set<TakenItem> takenItems) {
        this.takenItems = takenItems;
    }

    public int getActive() {return active;}

    public void setActive(int active) {this.active = active;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}