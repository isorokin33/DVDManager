package com.isorokin.dvdmanager.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TakenItemPK implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 6338500448988296571L;

    @ManyToOne
    private User user;

    @ManyToOne
    private Disk disk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DATE")
    private Date startDate;

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TakenItemPK)) return false;
        TakenItemPK that = (TakenItemPK) o;
        return Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getDisk(), that.getDisk()) &&
                Objects.equals(getStartDate(), that.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getDisk(), getStartDate());
    }
}