package com.ingress.job.jobingresstask.dao.specification;

import com.ingress.job.jobingresstask.dao.entity.JobEntity;
import com.ingress.job.jobingresstask.model.enums.ExperienceLevel;
import com.ingress.job.jobingresstask.model.enums.JobType;
import com.ingress.job.jobingresstask.model.filter.JobFilter;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

@UtilityClass
public class JobSpecification {

    public static Specification<JobEntity> getSpecification(JobFilter filter) {
        Specification<JobEntity> specification = Specification.where(null);

        if (filter != null) {
            if (StringUtils.hasText(filter.getLocation())) {
                specification = specification.and(hasLocation(filter.getLocation()));
            }
            if (filter.getType() != null) {
                specification = specification.and(JobSpecification.hasJobType(filter.getType()));
            }
            if (filter.getLevel() != null) {
                specification = specification.and(JobSpecification.hasExperienceLevel(filter.getLevel()));
            }
            if (StringUtils.hasText(filter.getIndustry())) {
                specification = specification.and(hasIndustry(filter.getIndustry()));
            }
            if (StringUtils.hasText(filter.getTag())) {
                specification = specification.and(hasTag(filter.getTag()));
            }
        }
        return specification;
    }

    public static Specification<JobEntity> hasLocation(String location) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("location"), location);
    }
    public static Specification<JobEntity> hasJobType(JobType type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("jobType"), type);
    }
    public static Specification<JobEntity> hasExperienceLevel(ExperienceLevel level) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("experienceLevel"), level);
    }
    public static Specification<JobEntity> hasIndustry(String industry) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("industry"), industry);
    }
    public static Specification<JobEntity> hasTag(String tag) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tags"), tag);
    }

}
