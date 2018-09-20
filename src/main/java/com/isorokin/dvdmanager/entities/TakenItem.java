package com.isorokin.dvdmanager.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TAKENITEM")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
                joinColumns = @JoinColumn(name = "USER_ID")),
        @AssociationOverride(name = "pk.disk",
                joinColumns = @JoinColumn(name = "DISK_ID")) })
public class TakenItem implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 5857613215235764215L;

    @EmbeddedId
    private TakenItemPK pk = new TakenItemPK();

    @Column(name="RENTED_STATUS")
    private Boolean rentedStatus;

    @Transient
    public User getUser()
    {
        return getPk().getUser();
    }

    public void setUser(User user)
    {
        getPk().setUser(user);
    }

    @Transient
    public Disk getDisk()
    {
        return getPk().getDisk();
    }

    public void setDisk(Disk disk)
    {
        getPk().setDisk(disk);
    }

    @Transient
    public Date getStartDate()
    {
        return getPk().getStartDate();
    }

    public void setStartDate(Date startDate)
    {
        getPk().setStartDate(startDate);
    }

    public TakenItemPK getPk() {
        return pk;
    }

    public void setPk(TakenItemPK pk) {
        this.pk = pk;
    }

    public Boolean getRentedStatus() {
        return rentedStatus;
    }

    public void setRentedStatus(Boolean rentedStatus) {
        this.rentedStatus = rentedStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TakenItem)) return false;
        TakenItem takenItem = (TakenItem) o;
        return Objects.equals(getPk(), takenItem.getPk()) &&
                Objects.equals(getRentedStatus(), takenItem.getRentedStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getRentedStatus());
    }
}