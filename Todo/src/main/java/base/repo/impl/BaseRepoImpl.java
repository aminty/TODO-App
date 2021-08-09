package base.repo.impl;

import base.entity.BaseEntity;
import base.repo.BaseRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class BaseRepoImpl<E extends BaseEntity> implements BaseRepo<E> {

    public   final EntityManager entityManager;

    public BaseRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
