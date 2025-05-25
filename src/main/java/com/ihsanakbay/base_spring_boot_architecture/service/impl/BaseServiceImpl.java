package com.ihsanakbay.base_spring_boot_architecture.service.impl;

import com.ihsanakbay.base_spring_boot_architecture.dto.response.PageResponse;
import com.ihsanakbay.base_spring_boot_architecture.exception.ResourceNotFoundException;
import com.ihsanakbay.base_spring_boot_architecture.model.BaseEntity;
import com.ihsanakbay.base_spring_boot_architecture.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity, ID> implements BaseService<T, ID> {

    protected final JpaRepository<T, ID> repository;
    protected final String entityName;

    protected BaseServiceImpl(JpaRepository<T, ID> repository, String entityName) {
        this.repository = repository;
        this.entityName = entityName;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public PageResponse<T> findAll(Pageable pageable) {
        Page<T> page = repository.findAll(pageable);
        return PageResponse.of(page);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public T update(T entity) {
        if (entity.getId() == null || !repository.existsById((ID) entity.getId())) {
            throw new ResourceNotFoundException(entityName, "id", entity.getId());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(entityName, "id", id);
        }
        repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll(List<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
