package com.isorokin.dvdmanager.controllers;

import com.isorokin.dvdmanager.entities.Disk;
import com.isorokin.dvdmanager.entities.TakenItem;
import com.isorokin.dvdmanager.entities.TakenItemPK;
import com.isorokin.dvdmanager.entities.User;
import com.isorokin.dvdmanager.services.DiskService;
import com.isorokin.dvdmanager.services.TakenItemService;
import com.isorokin.dvdmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class DiskController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiskService diskService;

    @Autowired
    private TakenItemService takenItemService;

    @RequestMapping(value="/admin/userdisks", method = RequestMethod.GET)
    public ModelAndView userDisks(){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        List<Disk> disks = diskService.findDiskByUser(user);
        modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
        modelAndView.addObject("disks",disks);
        modelAndView.setViewName("/admin/userdisks");
        return modelAndView;
    }

    @RequestMapping(value="/admin/adddisk", method = RequestMethod.GET)
    public ModelAndView viewAddDisk() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        Disk disk = new Disk();
        modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
        modelAndView.addObject("disk",disk);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/adddisk", method = RequestMethod.POST)
    public ModelAndView addDisk(@Valid Disk disk, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User user =userService.getCurrentUser();
        Disk nDisk = diskService.findDiskByUserAndName(user,disk.getName());
        if(nDisk != null) {
            bindingResult.rejectValue("/admin/adddisk", "successMessage","A disk with this name already exists");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/admin/adddisk");
        }   else {
                disk.setUser(user);
                diskService.saveDisk(disk);
                modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
                modelAndView.addObject("successMessage", "Disk save successfully");
                modelAndView.addObject("disk", new Disk());
                modelAndView.setViewName("/admin/adddisk");
        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/handeddisks", method = RequestMethod.GET)
    public ModelAndView viewHandedDisks(){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        List<TakenItem> takenItems = takenItemService.findTakenItemByUser(user);
        modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
        modelAndView.addObject("takenItems",takenItems);
        modelAndView.setViewName("/admin/handeddisks");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/takendisks", method = RequestMethod.GET)
    public ModelAndView viewTakenDisks() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        List<TakenItem> takenItems = takenItemService.findTakenItemByUserAndRentedStatus(user);
        modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
        modelAndView.addObject("takenItems",takenItems);
        modelAndView.setViewName("/admin/takendisks");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/returndisk", method = RequestMethod.POST)
    public String returnDisk(int disk_id, String startDate) throws Exception {
        User user = userService.getCurrentUser();
        TakenItemPK takenItemPK = new TakenItemPK();
        takenItemPK.setDisk(diskService.getDisk(disk_id));
        takenItemPK.setUser(user);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);

        takenItemPK.setStartDate(formatter.parse(startDate));
        TakenItem takenItem = takenItemService.findTakenItemByPK(takenItemPK);
        takenItem.setRentedStatus(false);
        takenItemService.saveTakenItem(takenItem);
        return "redirect:/admin/takendisks";
    }

    @RequestMapping(value = "/admin/freedisks", method = RequestMethod.GET)
    public ModelAndView viewFreeDisks() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        List<Disk> disks = diskService.findByFreeDisks(user);
        modelAndView.addObject("userName", user.getFullName() + "(" + user.getLogin() + ")");
        modelAndView.addObject("disks",disks);
        modelAndView.setViewName("/admin/freedisks");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/takedisk", method = RequestMethod.POST)
    public String takeDisk(int disk_id) {
        User user = userService.getCurrentUser();
        TakenItemPK takenItemPK = new TakenItemPK();
        takenItemPK.setDisk(diskService.getDisk(disk_id));
        takenItemPK.setUser(user);
        takenItemPK.setStartDate(new Date());
        TakenItem takenItem = new TakenItem();
        takenItem.setPk(takenItemPK);
        takenItem.setRentedStatus(true);
        takenItemService.saveTakenItem(takenItem);
        return "redirect:/admin/freedisks";
    }
}
