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
    public static final String getLibraryByLibrarianId = PropertiesLoader.loadProperty("endpoint.getLibraryByLibrarianId");
    public static final String getAllLibraries = PropertiesLoader.loadProperty("endpoint.getAllLibraries");
    public static final String getLibraryById = PropertiesLoader.loadProperty("endpoint.getLibraryById");
    public static final String libRegister = PropertiesLoader.loadProperty("endpoint.libRegister");
    public static final String libUpdate = PropertiesLoader.loadProperty("endpoint.libUpdate");
    public static final String libDelete = PropertiesLoader.loadProperty("endpoint.libDelete");
    public static final String addBook = PropertiesLoader.loadProperty("endpoint.addBook");
    public static final String addBookFromJson = PropertiesLoader.loadProperty("endpoint.addBookFromJson");
    public static final String updateBook = PropertiesLoader.loadProperty("endpoint.updateBook");
    public static final String deleteBook = PropertiesLoader.loadProperty("endpoint.deleteBook");
    public static final String getAllBooks = PropertiesLoader.loadProperty("endpoint.getAllBooks");
    public static final String getAllBooksInTheLibrary = PropertiesLoader.loadProperty("endpoint.getAllBooksInTheLibrary");
    public static final String getBookByTitle = PropertiesLoader.loadProperty("endpoint.getBookByTitle");
    public static final String getBookByIsbn = PropertiesLoader.loadProperty("endpoint.getBookByIsbn");
    public static final String getBookByAuthor = PropertiesLoader.loadProperty("endpoint.getBookByAuthor");
    public static final String getBookById = PropertiesLoader.loadProperty("endpoint.getBookById");
    public static final String addBookToCart = PropertiesLoader.loadProperty("endpoint.addBookToCart");
    public static final String getAllBooksInTheCart = PropertiesLoader.loadProperty("endpoint.getAllBooksInCart");
    public static final String deleteBookFromCart = PropertiesLoader.loadProperty("endpoint.deleteBookFromCart");

}
