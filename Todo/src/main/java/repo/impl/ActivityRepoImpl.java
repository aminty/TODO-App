package repo.impl;

import base.repo.impl.BaseRepoImpl;
import entity.Activity;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ActivityRepoImpl extends BaseRepoImpl<Activity> {

    public ActivityRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Activity find(int id) {
        return null;
    }

    @Override
    public Activity[] findAllById(int[] ids) {
        return new Activity[0];
    }

    @Override
    public void insert(Activity entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Activity update(Activity entity) {
        return null;
    }

    @Override
    public boolean isExist(Activity entity) {
        return false;
    }

    @Override
    public Boolean existsById(int id) {
        return null;
    }
}
