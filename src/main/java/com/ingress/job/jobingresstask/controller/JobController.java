package com.ingress.job.jobingresstask.controller;

import com.ingress.job.jobingresstask.model.filter.JobFilter;
import com.ingress.job.jobingresstask.model.response.JobView;
import com.ingress.job.jobingresstask.model.response.PageableResponse;
import com.ingress.job.jobingresstask.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/jobs")
public class JobController {

    private final JobService service;

    @GetMapping
    public ResponseEntity<PageableResponse<JobView>> getALlJobs(JobFilter jobFilter) {
        return ResponseEntity.ok(service.getAll(jobFilter));
    }
}
