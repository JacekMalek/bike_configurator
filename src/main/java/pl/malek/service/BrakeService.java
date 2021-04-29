package pl.malek.service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrakeService implements MethodInterface{
    @Override
    public List getAll() {
        return null;
    }
   // TODO Dokończyć BrakeService

    @Override
    public void add(Object o) {

    }

    @Override
    public Optional get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Object o) {

    }
}