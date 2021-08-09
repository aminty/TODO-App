package service;

import repo.impl.ActivityRepoImpl;
import repo.impl.UserRepoImpl;
import service.menu.UserMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationObject {
    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    private static final EntityManager enityManager = entityManagerFactory.createEntityManager();
    private static final UserRepoImpl USER_REPO_IMPL = new UserRepoImpl(enityManager);
    private static final ActivityRepoImpl ACTIVITY_REPO_IMPL = new ActivityRepoImpl(enityManager);
    private static Validation validation = new Validation();
    private static UserMenu userMenu=new UserMenu();

    public static UserMenu getUserMenu() {
        return userMenu;
    }

    public static UserRepoImpl getUserRepo() {
        return USER_REPO_IMPL;
    }

    public static ActivityRepoImpl getActivityRepo() {
        return ACTIVITY_REPO_IMPL;
    }

    public static EntityManager getEnityManager() {
        return enityManager;
    }

    public static Validation getValidation() {
        return validation;
    }


}
