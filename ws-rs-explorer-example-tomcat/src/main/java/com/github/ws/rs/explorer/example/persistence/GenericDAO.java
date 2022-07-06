package com.github.ws.rs.explorer.example.persistence;


import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class GenericDAO {

    @Inject
    private transient EntityManager em;

    public GenericDAO() {
    }

    public <E> Optional<E> find(Class<E> entityClass, Object id) {
        var entity = this.em.find(entityClass, id);
        return Optional.ofNullable(entity);
    }
}
