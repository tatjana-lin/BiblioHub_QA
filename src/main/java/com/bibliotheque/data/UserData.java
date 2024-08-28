package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

import java.util.Random;

public class UserData {

    public static final String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static final String validPassword = PropertiesLoader.loadProperty("valid.password");
    public static final String adminEmail = PropertiesLoader.loadProperty("admin.email");
    public static final String adminPassword = PropertiesLoader.loadProperty("admin.password");
    public static final String emptyEmail = PropertiesLoader.loadProperty("empty.email");
    public static final String emptyPassword = PropertiesLoader.loadProperty("empty.password");
    public static final String emptyRepeatPass = PropertiesLoader.loadProperty("empty.repeatPass");
    public static final String invalidEmail = PropertiesLoader.loadProperty("invalid.email");
    public static final String invalidPassword = PropertiesLoader.loadProperty("invalid.password");
    public static final String invalidPassConfirm = PropertiesLoader.loadProperty("invalid.passConfirm");
    public static final String wrongEmail = PropertiesLoader.loadProperty("wrong.email");
    public static final String wrongPassword = PropertiesLoader.loadProperty("wrong.password");
    public static final String registerEmail = PropertiesLoader.loadProperty("register.email");
    public static final String registerPassword = PropertiesLoader.loadProperty("register.password");
    public static final String blockedEmail = PropertiesLoader.loadProperty("blocked_user.email");
    public static final String blockedPassword = PropertiesLoader.loadProperty("blocked_user.password");
    public static final String unlockedEmail = PropertiesLoader.loadProperty("unlocked_user.email");
    public static final String unlockedPassword = PropertiesLoader.loadProperty("unlocked_user.password");
    public static final String roleUser = PropertiesLoader.loadProperty("role.user");
    public static final String roleLibrary = PropertiesLoader.loadProperty("role.library");
    public static final String roleAdmin = PropertiesLoader.loadProperty("role.admin");

    public static final String firstName = PropertiesLoader.loadProperty("profile.fName");
    public static final String lastName = PropertiesLoader.loadProperty("profile.lName");
    public static final String phone = PropertiesLoader.loadProperty("profile.phone");
    public static final String country = PropertiesLoader.loadProperty("profile.country");
    public static final String zip = PropertiesLoader.loadProperty("profile.zip");
    public static final String city = PropertiesLoader.loadProperty("profile.city");
    public static final String street = PropertiesLoader.loadProperty("profile.street");
    public static final String house = PropertiesLoader.loadProperty("profile.house");
    public static final String newStreet = PropertiesLoader.loadProperty("profile.newStreet");
    public static final String newHouse = PropertiesLoader.loadProperty("profile.newHouse");


}
