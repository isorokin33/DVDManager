package com.isorokin.dvdmanager.repositories;

import com.isorokin.dvdmanager.entities.Disk;
import com.isorokin.dvdmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("diskRepository")
public interface DiskRepository extends JpaRepository<Disk, Integer> {
    List<Disk> findDiskByUser(User user);

    Disk findByUserAndName(User user, String name);

    @Query("SELECT d FROM Disk d WHERE d.user.id <> :user_id AND d.id NOT IN (SELECT ti.pk.disk.id FROM TakenItem ti WHERE ti.rentedStatus = true)")
    List<Disk> findByFreeDisks(@Param("user_id") int user_id);
}
