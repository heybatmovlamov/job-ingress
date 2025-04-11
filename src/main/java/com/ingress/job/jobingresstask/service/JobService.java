package com.ingress.job.jobingresstask.service;

import com.ingress.job.jobingresstask.dao.entity.JobEntity;
import com.ingress.job.jobingresstask.dao.repository.JobRepository;
import com.ingress.job.jobingresstask.dao.specification.JobSpecification;
import com.ingress.job.jobingresstask.mapper.JobMapper;
import com.ingress.job.jobingresstask.model.filter.JobFilter;
import com.ingress.job.jobingresstask.model.response.JobView;
import com.ingress.job.jobingresstask.model.response.PageableResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    public PageableResponse<JobView> getAll(JobFilter filter) {
        Sort sort = Sort.by(filter.getSortDirection(),
                            filter.getSortBy());

        final Pageable pageable = PageRequest.of(filter.getPageNumber(),
                                                 filter.getPageSize(),
                                                 sort);

        final Specification<JobEntity> specification = JobSpecification.getSpecification(filter);

        Page<JobEntity> jobs = jobRepository.findAll(specification, pageable);
        log.info(jobs.getContent().toString());
        List<JobView> view = jobMapper.toView(jobs.getContent());
        log.info(view.toString());

        return PageableResponse.<JobView>builder()
                .data(view)
                .pageNumber(jobs.getNumber())
                .pageSize(jobs.getSize())
                .totalElements(jobs.getTotalElements())
                .totalPages(jobs.getTotalPages())
                .build();
    }
}
