package com.ingress.job.jobingresstask.model.response;

import com.ingress.job.jobingresstask.model.enums.ExperienceLevel;
import com.ingress.job.jobingresstask.model.enums.JobType;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobView {

    private UUID id;
    private String jobTitle;
    private String companyName;
    private String location;
    private JobType jobType;
    private Integer salaryMin;
    private Integer salaryMax;
    private String jobDescription;
    private String requirements;
    private String educationLevel;
    private String industry;
    private LocalDate postedDate;
    private String howToApply;
    private String companyLogo;
    private String benefits;
    private String tags;
    private String source;
    private ExperienceLevel experienceLevel;
    private LocalDate applicationDeadline;
}
