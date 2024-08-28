package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

public class LibraryData {

    public static final String id = PropertiesLoader.loadProperty("library.id");
    public static final String email = PropertiesLoader.loadProperty("library.email");
    public static final String password = PropertiesLoader.loadProperty("library.password");
    public static final String name = PropertiesLoader.loadProperty("library.name");
    public static final String oldName = PropertiesLoader.loadProperty("library.oldName");
    public static final String country = PropertiesLoader.loadProperty("library.country");
    public static final String city = PropertiesLoader.loadProperty("library.city");
    public static final String street = PropertiesLoader.loadProperty("library.street");
    public static final String number = PropertiesLoader.loadProperty("library.number");
    public static final String zip = PropertiesLoader.loadProperty("library.zip");
    public static final String phone = PropertiesLoader.loadProperty("library.phone");
    public static final String oldPhone = PropertiesLoader.loadProperty("library.oldPhone");
    public static final String librarianId = PropertiesLoader.loadProperty("library.librarianId");

}
