package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

public class UserData {

    public static final String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static final String validPassword = PropertiesLoader.loadProperty("valid.password");
    public static final String emptyEmail = PropertiesLoader.loadProperty("empty.email");
    public static final String emptyPassword = PropertiesLoader.loadProperty("empty.password");
    public static final String emptyRepeatPass = PropertiesLoader.loadProperty("empty.repeatPass");
    public static final String invalidEmail = PropertiesLoader.loadProperty("invalid.email");
    public static final String invalidPassConfirm = PropertiesLoader.loadProperty("invalid.passConfirm");


}
