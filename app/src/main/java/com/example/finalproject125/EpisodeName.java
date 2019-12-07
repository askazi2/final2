package com.example.finalproject125;

public class EpisodeName {
    // in this class we need to incorporate the JSON objects and the API
    // we need to get a title from the user using a webrequest (maybe?) and then using the filter class
    // in NewActivity filter out the names by using .equals to compare the Strings
    // there are multiple APIs we need to use and specifically in this one we need to get all of
    // list of shows on Netflix and add them to the array in NewActivity in order for thic class to work
    // Later on we can get the IMBD attached by using the ID given in the JSON object returned by the API
    public String title;
    public EpisodeName(String var1) {
        title = var1;
    }
    private String getTitle() {
        return title;
    }
}
