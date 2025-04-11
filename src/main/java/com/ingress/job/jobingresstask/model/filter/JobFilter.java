package com.ingress.job.jobingresstask.model.filter;

import com.ingress.job.jobingresstask.model.enums.ExperienceLevel;
import com.ingress.job.jobingresstask.model.enums.JobType;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobFilter {

    @Min(0)
    private int pageNumber = 0;
    @Min(1)
    private int pageSize = 20;
    private String location;
    private JobType type;
    private ExperienceLevel level;
    private String industry;
    private String tag;
    @Builder.Default
    private String sortBy = "postedDate";
    @Builder.Default
    private String sortDirection = "salaryMin";
}


