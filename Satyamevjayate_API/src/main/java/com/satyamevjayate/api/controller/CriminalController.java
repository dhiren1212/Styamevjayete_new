package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.services.CriminalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriminalController {
    @Autowired
    private CriminalServices criminalServices;

    @GetMapping("/criminal")
    public List<Criminal> getAllCriminal() {
        return criminalServices.listAllCriminal();
    }

    @GetMapping("/criminal/{id}")
    public Criminal getCriminal(@PathVariable Long id)
    {
        Criminal w= criminalServices.getCriminal(id);
        return w;
    }

    @PostMapping("/criminal")
    public String addCriminal(@RequestBody Criminal w)
    {
        criminalServices.saveCriminal(w);
        return "Criminal Add successfully";

    }

    @DeleteMapping("/criminal/{id}")
    public String deleteCriminal(@PathVariable Long id)
    {
        criminalServices.deleteCriminal(id);
        return "Criminal Delete successfully";
    }

    @PutMapping("/criminal/{id}")
    public Long editCriminal(@RequestBody Criminal criminal, @PathVariable Long id) {


        Long criminalId=criminalServices.editCriminal(criminal,id);

        return criminalId;
    }

}
