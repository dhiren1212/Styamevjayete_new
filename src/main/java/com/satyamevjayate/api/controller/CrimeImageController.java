package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeImage;
import com.satyamevjayate.api.services.CrimeImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class CrimeImageController {
    @Autowired
    private CrimeImageServices CrimeImageServices;

    @GetMapping("/crimeImage")
    public List<CrimeImage> getAllCrimeImage() {
        return CrimeImageServices.listAllCrimeImage();
    }

    @GetMapping("/crimeImage/{id}")
    public CrimeImage getCrimeImage(@PathVariable BigInteger id)
    {

        CrimeImage CrimeImage= CrimeImageServices.getCrimeImage(id);
        return CrimeImage;



    }

    @PostMapping("/crimeImage")
    public String addCrimeImage(@RequestBody CrimeImage CrimeImage)
    {
        CrimeImageServices.saveCrimeImage(CrimeImage);;
        return "CrimeImage Add Successfully";
    }


    @DeleteMapping("/crimeImage/{id}")
    public String deleteCrimeImage(@PathVariable BigInteger id)
    {
        CrimeImageServices.deleteCrimeImage(id);;
        return "Delete CrimeImage Successfully";
    }

    @PutMapping("/crimeImage/{id}")
    public ResponseEntity<Object> editCrimeImage(@RequestBody CrimeImage CrimeImage, @PathVariable BigInteger id) {

        CrimeImage.setCrimeImageID(id);

        CrimeImageServices.saveCrimeImage(CrimeImage);

        return ResponseEntity.noContent().build();
    }
}
