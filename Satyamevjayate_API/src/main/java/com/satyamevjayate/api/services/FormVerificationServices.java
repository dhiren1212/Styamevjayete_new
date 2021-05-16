package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Formverification;
import com.satyamevjayate.api.repo.FormVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class FormVerificationServices {
    @Autowired
    private FormVerificationRepository FormVerification_repo;

    public List<Formverification> listAllFormVerification()
    {
        return FormVerification_repo.findAll();
    }

    public Long saveFormVerification(Formverification formverification)
    {
        FormVerification_repo.save(formverification);
        return formverification.getFormVerifiactionID();
    }

    public Formverification getFormVerification(Long Id)
    {
        return FormVerification_repo.findById(Id).get();
    }

    public void deleteFormVerification(Long Id)
    {
        FormVerification_repo.deleteById(Id);
    }
    public Long updateFormVerification(Formverification formverification,Long Id)
    {
        FormVerification_repo.save(formverification);
        return Id;
    }
}
