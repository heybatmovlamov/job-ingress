package com.ingress.job.jobingresstask.dao.entity;

import com.ingress.job.jobingresstask.model.enums.ExperienceLevel;
import com.ingress.job.jobingresstask.model.enums.JobType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@ToString
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "job_entity")
@Entity
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "location")
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType;

    @Column(name = "salary_min")
    private Integer salaryMin;

    @Column(name = "salary_max")
    private Integer salaryMax;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "requirements")
    private String requirements;

    @Enumerated(EnumType.STRING)
    @Column(name = "experience_level")
    private ExperienceLevel experienceLevel;

    @Column(name = "education_level")
    private String educationLevel;

    @Column(name = "industry")
    private String industry;

    @Column(name = "posted_date", insertable = false, updatable = false)
    private LocalDate postedDate;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "how_to_apply")
    private String howToApply;

    @Column(name = "company_logo")
    private String companyLogo;

    @Column(name = "benefits")
    private String benefits;

    @Column(name = "tags")
    private String tags;

    @Column(name = "source")
    private String source;
}
