package com.opu.fluxr2db.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("tasks")
public class Task {
    @Id
    private Long id;
    private String name;
    private String description;
}