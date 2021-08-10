package repo.impl;

import base.repo.impl.BaseRepoImpl;
import entity.Activity;
import entity.User;
import repo.ActivityRepo;
import service.PrintMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ActivityRepoImpl extends BaseRepoImpl<Activity> implements ActivityRepo {

    public ActivityRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Activity find(int id) {

        Activity found=entityManager.find(Activity.class,id);

        return found;
    }

    @Override
    public Activity[] findAllById(int[] ids) {
        return new Activity[0];
    }

    @Override
    public void insert(Activity entity) {

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        PrintMessage.showMsg("Activity added .");

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Activity update(Activity entity) {

        Activity activity=entityManager.find(Activity.class,entity.getId());
        entityManager.getTransaction().begin();

        activity.setStatus(entity.getStatus());
        entityManager.merge(activity);
        entityManager.getTransaction().commit();
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

    @Override
    public List<Activity> sellectAll(int id) {
        Query query=entityManager.createQuery(" from Activity  where user_id=:id",Activity.class);
        query.setParameter("id",id);
        //todo
        List<Activity> activities=query.getResultList();
        for (Activity a : activities) {
            System.out.println(a.toString());
        }
        return activities;
    }
}
