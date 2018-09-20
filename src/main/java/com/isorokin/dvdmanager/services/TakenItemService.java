package com.isorokin.dvdmanager.services;


import com.isorokin.dvdmanager.entities.TakenItem;
import com.isorokin.dvdmanager.entities.TakenItemPK;
import com.isorokin.dvdmanager.entities.User;
import com.isorokin.dvdmanager.repositories.TakenItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("takenItemService")
public class TakenItemService {
    private TakenItemRepository takenItemRepository;

    @Autowired
    public TakenItemService (TakenItemRepository takenItemRepository) {
        this.takenItemRepository = takenItemRepository;
    }

    public List<TakenItem> findTakenItemByUser(User user){
        return takenItemRepository.findByUserDiskAndRentedStatus(user.getId());
    }

    public TakenItem findTakenItemByPK(TakenItemPK takenItemPK) {
        return takenItemRepository.getByPk(takenItemPK);
    }

    public TakenItem saveTakenItem(TakenItem takenItem) {return takenItemRepository.save(takenItem);}

    public List<TakenItem> findTakenItemByUserAndRentedStatus(User user) {return takenItemRepository.findByUserAndRentedStatus(user.getId());}
}
