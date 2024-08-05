package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

public class MessageData {

    public static final String emailErrorMessage = PropertiesLoader.loadProperty("message.emailError");
    public static final String emailErrorMessageReg = PropertiesLoader.loadProperty("message.emailErrorReg");
    public static final String emailRequiredMessage = PropertiesLoader.loadProperty("message.emailRequired");
    public static final String passwordRequiredMessage = PropertiesLoader.loadProperty("message.passwordRequired");
    public static final String repeatPassRequiredMessage = PropertiesLoader.loadProperty("message.repeatPassRequired");
    public static final String alreadyExistsMessage = PropertiesLoader.loadProperty("message.alreadyExists");
    public static final String invalidPassConfirmMessage = PropertiesLoader.loadProperty("message.invalidPassConfirm");


}
