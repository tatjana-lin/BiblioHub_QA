package com.bibliotheque.data;

import com.bibliotheque.utils.PropertiesLoader;

public class BookData {
//title = Maria Stuart
//authorName = Friedrich
//authorSurname = Schiller
//year = 2001
//isbn = 9783150000649
//publisher = Reclam
    public static final String title = PropertiesLoader.loadProperty("title");
    public static final String authorName = PropertiesLoader.loadProperty("authorName");
    public static final String authorSurname = PropertiesLoader.loadProperty("authorSurname");
    public static final String year = PropertiesLoader.loadProperty("year");
    public static final String isbn = PropertiesLoader.loadProperty("isbn");
    public static final String publisher = PropertiesLoader.loadProperty("publisher");
    public static final String filePath = PropertiesLoader.loadProperty("filePath");

}
