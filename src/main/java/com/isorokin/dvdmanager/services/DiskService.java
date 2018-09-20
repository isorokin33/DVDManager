package com.isorokin.dvdmanager.services;

import com.isorokin.dvdmanager.entities.Disk;
import com.isorokin.dvdmanager.entities.User;
import com.isorokin.dvdmanager.repositories.DiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("diskService")
public class DiskService {
    private DiskRepository diskRepository;

    @Autowired
    public DiskService(DiskRepository diskRepository){
        this.diskRepository = diskRepository;
    }

    public List<Disk> findDiskByUser(User user){return diskRepository.findDiskByUser(user);}

    public Disk findDiskByUserAndName(User user, String name) {return diskRepository.findByUserAndName(user,name);}

    public Disk saveDisk(Disk disk) {return diskRepository.save(disk);}

    public Disk getDisk(int disk_id) {return diskRepository.getOne(disk_id);}

    public List<Disk> findByFreeDisks(User user) {return diskRepository.findByFreeDisks(user.getId());}
}
