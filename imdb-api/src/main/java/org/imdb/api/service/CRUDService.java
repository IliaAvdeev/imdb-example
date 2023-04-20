package org.imdb.api.service;

import java.util.List;

public interface CRUDService<Domain> {

    List<Domain> getAll();

    Domain create(Domain domain);
}