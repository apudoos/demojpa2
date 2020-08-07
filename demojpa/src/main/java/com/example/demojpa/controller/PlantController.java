package com.example.demojpa.controller;

import com.example.demojpa.data.Plant;
import com.example.demojpa.dto.PlantDTO;
import com.example.demojpa.service.PlantService;
import com.example.demojpa.service.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        //Plant plant = plantService.getPlantByName(name);
        return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
}
