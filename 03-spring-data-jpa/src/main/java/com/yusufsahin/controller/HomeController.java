package com.yusufsahin.controller;

import com.yusufsahin.dto.DtoHome;
import com.yusufsahin.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/api/home")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(path = "/list/{id}")
    public DtoHome findHomeById(@PathVariable(name = "id") Integer id) {
        return homeService.findHomeById(id);
    }
}
