# JOB Application Setup and Instructions

This guide will help you set up a simple Spring Boot application to manage job postings. The application allows you to fetch all job postings and add new ones.

## Initial Setup

1. **Initialize the Project:**
    - Go to [Spring Initializr](https://start.spring.io/).
    - Configure the project with the following settings:
        - Project: Maven Project
        - Language: Java
        - Spring Boot: 2.5.4 (or latest stable version)
        - Group: `com.mukesh`
        - Artifact: `firstjobApp`
        - Dependencies: Spring Web
    - Click on "Generate" to download the project.
    - Extract the downloaded zip file.
    - Open the project in IntelliJ IDEA.

2. **Create a New Package:**
    - In the `src/main/java/com/mukesh/firstjobApp` directory, create a new package named `job`.

## Implementing Job Functionality

### 1. Create Job Class

The `Job` class defines the structure of a job.

Create a file named `Job.java` in the `job` package with the following content:

```java
package com.mukesh.firstjobApp.job;

public class Job {
    private long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job(long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
```

### 2. Create JobController Class

The `JobController` class will handle HTTP requests to manage jobs.

Create a file named `JobController.java` in the `job` package with the following content:

```java
package com.mukesh.firstjobApp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobs;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobs.add(job);
        return "Job added successfully";
    }
}
```

## Running the Application

1. **Run the Application:**
    - In IntelliJ IDEA, run the application by clicking the `Run` button or by executing the `main` method in the `FirstjobAppApplication.java` class.

2. **Test the Endpoints:**
    - **Fetch All Jobs:**
        - Open a browser or a tool like Postman.
        - Make a GET request to `http://localhost:8080/jobs`.
    - **Add a Job:**
        - In Postman, make a POST request to `http://localhost:8080/jobs` with a JSON body similar to the following:
          ```json
          {
              "id": 1,
              "title": "Software Developer",
              "description": "Develop and maintain software applications.",
              "minSalary": "50000",
              "maxSalary": "70000",
              "location": "New York"
          }
          ```

