package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

public class EndpointData {

    public static final String login = PropertiesLoader.loadProperty("endpoint.login");
    public static final String refresh = PropertiesLoader.loadProperty("endpoint.refresh");
    public static final String register = PropertiesLoader.loadProperty("endpoint.register");
    public static final String delete = PropertiesLoader.loadProperty("endpoint.delete");
    public static final String getAllUsers = PropertiesLoader.loadProperty("endpoint.getAllUsers");
    public static final String block = PropertiesLoader.loadProperty("endpoint.block");
    public static final String unlock = PropertiesLoader.loadProperty("endpoint.unlock");
    public static final String update = PropertiesLoader.loadProperty("endpoint.update");

}
