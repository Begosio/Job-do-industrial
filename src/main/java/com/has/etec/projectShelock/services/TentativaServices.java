package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.repositories.TentativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TentativaServices {
    @Autowired
    public TentativaRepository tentativaRepository;

    public TentativaServices(TentativaRepository tentativaRepository) {
        this.tentativaRepository = tentativaRepository;
    }
}
