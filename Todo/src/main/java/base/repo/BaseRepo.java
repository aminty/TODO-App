package base.repo;

import base.entity.BaseEntity;

public interface BaseRepo<E extends BaseEntity> {

    E find(int id);

    E[] findAllById(int[] ids);

    void insert(E entity);

    void deleteById(int id);

    E update(E entity);

    boolean isExist(E entity);


    Boolean existsById(int id);


}