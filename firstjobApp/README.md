## JOB Application 

1. first initialise the project from `star.spring.io` add dependecies live spring web. now extract and open in intellije 
2. create a new package `job` under the `com` package

### fetch all jobs 

- create a class JobController.java and Job.java

Job -> structure of job 

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

jobController.java -> for fetch all jobs 
```java
package com.mukesh.firstjobApp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private  List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }
}

```