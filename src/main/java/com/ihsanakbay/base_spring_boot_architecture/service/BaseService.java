package com.ihsanakbay.base_spring_boot_architecture.service;

import com.ihsanakbay.base_spring_boot_architecture.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    
    List<T> findAll();
    
    PageResponse<T> findAll(Pageable pageable);
    
    Optional<T> findById(ID id);
    
    T save(T entity);
    
    List<T> saveAll(List<T> entities);
    
    T update(T entity);
    
    void deleteById(ID id);
    
    void delete(T entity);
    
    void deleteAll(List<T> entities);
    
    long count();
    
    boolean existsById(ID id);
}
