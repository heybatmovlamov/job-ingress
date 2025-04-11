package com.ingress.job.jobingresstask.dao.repository;

import com.ingress.job.jobingresstask.dao.entity.JobEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository
        extends JpaRepository<JobEntity, UUID>, JpaSpecificationExecutor<JobEntity> {
}
