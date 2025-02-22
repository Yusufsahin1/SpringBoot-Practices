package com.yusufsahin.services;

import com.yusufsahin.dto.DtoHome;
import com.yusufsahin.dto.DtoRoom;
import com.yusufsahin.entities.Home;
import com.yusufsahin.entities.Room;
import com.yusufsahin.repository.HomeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public DtoHome findHomeById(Integer id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        Home dbHome = optional.get();
        List<Room> dbRooms = optional.get().getRooms();

        BeanUtils.copyProperties(dbHome, dtoHome);

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getDtoRoom().add(dtoRoom);
            }
        }
        return dtoHome;
    }
}

