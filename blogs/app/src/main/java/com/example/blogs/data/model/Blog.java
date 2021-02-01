package com.example.blogs.data.model;

public class Blog {
    private final int Id;
    private final String name;
    private final String description;
    private final String url;
    private final String rssFeed;
    private final String submittedDate;

    public Blog(int id, String name, String description, String url, String rssFeed, String submittedDate) {
        Id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.rssFeed = rssFeed;
        this.submittedDate = submittedDate;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getRssFeed() {
        return rssFeed;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }
}
