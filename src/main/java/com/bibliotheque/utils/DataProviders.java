package com.bibliotheque.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    String path;

    private List<Object[]> getList(String path) throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list;
    }

    @DataProvider
    public Iterator<Object[]> positiveRegistrationFromCsv() throws IOException {

        path = "src/test/resources/user.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> negativeRegistrationWithInvalidEmailFromCsv() throws IOException {

        path = "src/test/resources/regNegEmail.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> negativeRegistrationWithInvalidPassFromCsv() throws IOException {

        path = "src/test/resources/regNegPass.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> negativeLoginWithInvalidEmailFromCsv() throws IOException {

        path = "src/test/resources/loginNegEmail.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> negativeLoginWithInvalidPassFromCsv() throws IOException {

        path = "src/test/resources/loginNegPass.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> positiveSearchByTitleFromCsv() throws IOException {

        path = "src/test/resources/searchTitlePos.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> positiveSearchByAuthorFromCsv() throws IOException {

        path = "src/test/resources/searchAuthorPos.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> negativeSearchFromCsv() throws IOException {

        path = "src/test/resources/searchNeg.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> negativeLoginWithInvalidPassApi() throws IOException {

        path = "src/test/resources/loginNegPassApi.csv";
        List<Object[]> list = getList(path);
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeRegistrationWithInvalidEmailApi() throws IOException {

        path = "src/test/resources/regNegEmailApi.csv";
        List<Object[]> list = getList(path);
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeRegistrationWithInvalidPassApi() throws IOException {

        path = "src/test/resources/regNegPassApi.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> positiveRegistrationApi() throws IOException {

        path = "src/test/resources/user_api.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> positiveDeleteApi() throws IOException {

        path = "src/test/resources/userDelApi.csv";
        List<Object[]> list = getList(path);
        return list.iterator();

    }


}
