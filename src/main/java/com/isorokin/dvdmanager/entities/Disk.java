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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DISKS")
public class Disk implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 8401336514074293039L;

    @Id
    @Column(name="DISK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy = "pk.disk", cascade=CascadeType.ALL)
    private Set<TakenItem> takenItems = new HashSet<TakenItem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<TakenItem> getTakenItems() {
        return takenItems;
    }

    public void setTakenItems(Set<TakenItem> takenItems) {
        this.takenItems = takenItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disk)) return false;
        Disk disk = (Disk) o;
        return getId() == disk.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}