package com.CommentControlSystem.General.service;

import com.CommentControlSystem.General.entity.BaseAdditionalFields;
import com.CommentControlSystem.General.entity.BaseEntity;
import com.CommentControlSystem.General.enums.ErrorMessage;
import com.CommentControlSystem.General.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E, Long>> {

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E entity){

        entity = dao.save(entity);

        return entity;
    }


    public void delete(E entity){
        dao.delete(entity);
    }

    public E getByIdWithControl(Long id) {

        Optional<E> entityOptional = findById(id);

        E entity;
        if (entityOptional.isPresent()){
            entity = entityOptional.get();
        } else {
            throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND);
        }

        return entity;
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }

    public D getDao() {
        return dao;
    }
}