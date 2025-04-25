package com.example.futergoal.dto;

import java.math.BigDecimal;

import com.example.futergoal.entities.JobIdea.JobDifficulty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoJobIdeaIU {

	
    private String title;
    private String description;
    private BigDecimal budget;
    private JobDifficulty difficulty;
}
