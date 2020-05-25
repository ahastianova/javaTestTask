package com.test;

public class User {
    private long id;
    private Vacancy vacancy;

    public User(long id, String vacancyName) {
        this.id = id;
        this.vacancy = new Vacancy(vacancyName);
    }

    public long getId() {
        return id;
    }

    public String getVacancy () {
        return vacancy.getName();
    }
}
