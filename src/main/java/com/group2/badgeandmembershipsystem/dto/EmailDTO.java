package com.group2.badgeandmembershipsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String toAddress;
    private String password;
    private String subject;
    private String body;
}
