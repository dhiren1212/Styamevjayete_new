package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeImage;
import com.satyamevjayate.api.services.CrimeImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CrimeImageController {
    @Autowired
    private CrimeImageServices crimeImageServices;

    @GetMapping("/crimeImage")
    public List<CrimeImage> getAllCrimeImage() {
        return crimeImageServices.listAllCrimeImage();
    }

    @GetMapping("/crimeImage/{id}")
    public CrimeImage getCrimeImage(@PathVariable Long id)
    {

        CrimeImage CrimeImage= crimeImageServices.getCrimeImage(id);
        return CrimeImage;



    }

    @PostMapping("/crimeImage")
    public Long addCrimeImage(@RequestBody CrimeImage crimeImage)
    {
        Long id= crimeImageServices.saveCrimeImage(crimeImage);;
        return id;
    }


    @DeleteMapping("/crimeImage/{id}")
    public String deleteCrimeImage(@PathVariable Long id)
    {
        crimeImageServices.deleteCrimeImage(id);;
        return "Delete CrimeImage Successfully";
    }

    @PutMapping("/crimeImage/{id}")
    public Long editCrimeImage(@RequestBody CrimeImage crimeImage, @PathVariable Long id) {

        Long crimeImageId= crimeImageServices.updateCrimeIamge(crimeImage,id);

        return crimeImageId;
    }
}
