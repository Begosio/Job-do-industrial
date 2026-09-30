package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.repositories.ResultadoRepository;
import com.has.etec.projectShelock.repositories.SuspeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspeitoService {

    @Autowired
    public SuspeitoRepository suspeitoRepository;

    public SuspeitoService(SuspeitoRepository suspeitoRepository) {
        this.suspeitoRepository = suspeitoRepository;
    }
}
