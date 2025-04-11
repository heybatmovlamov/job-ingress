package com.ingress.job.jobingresstask.mapper;

import com.ingress.job.jobingresstask.dao.entity.JobEntity;
import com.ingress.job.jobingresstask.model.response.JobView;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobView toView(JobEntity jobEntity);

    JobEntity toEntity(JobView jobView);

    List<JobView> toView(List<JobEntity> jobEntities);

    List<JobEntity> toEntity(List<JobView> jobViews);
}