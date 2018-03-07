package ru.sarrz.lan.web;

import ru.sarrz.lan.model.AbstractNameEntity;

public class AuthorizedUser {
    private static int id = AbstractNameEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

}
