package com.bytecode.crudnotas.service.serviceimpl;

import com.bytecode.crudnotas.repository.NotaRepository;
import com.bytecode.crudnotas.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Override
    public void eliminarnota(long id) {
        notaRepository.deleteById(id);
    }
}
