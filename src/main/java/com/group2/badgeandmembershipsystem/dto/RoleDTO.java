package com.group2.badgeandmembershipsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
    private long id;
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
