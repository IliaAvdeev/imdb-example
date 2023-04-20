package org.imdb.impl.service;

import org.imdb.api.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class CRUDServiceImpl<Domain> implements CRUDService<Domain> {
    @Autowired
    private JpaRepository<Domain, UUID> repository;

    @Override
    public List<Domain> getAll() {
        return postGetAll(repository.findAll());
    }

    @Override
    public Domain create(Domain domain) {
        return repository.save(domain);
    }

    protected List<Domain> postGetAll(List<Domain> entities) {
        return entities;
    }
}