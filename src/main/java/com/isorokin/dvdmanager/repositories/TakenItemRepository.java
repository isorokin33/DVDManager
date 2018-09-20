package com.isorokin.dvdmanager.repositories;

import com.isorokin.dvdmanager.entities.TakenItem;
import com.isorokin.dvdmanager.entities.TakenItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("takenItemRepository")
public interface TakenItemRepository extends JpaRepository<TakenItem,Integer> {
    @Query("SELECT ti FROM TakenItem ti WHERE ti.rentedStatus = true and ti.pk.disk.user.id = :user_id")
    List<TakenItem> findByUserDiskAndRentedStatus(@Param("user_id") int user_id);

    TakenItem getByPk(TakenItemPK takenItemPK);

    @Query("SELECT ti FROM TakenItem ti WHERE ti.rentedStatus = true and ti.pk.user.id = :user_id")
    List<TakenItem> findByUserAndRentedStatus(@Param("user_id") int user_id);
}
