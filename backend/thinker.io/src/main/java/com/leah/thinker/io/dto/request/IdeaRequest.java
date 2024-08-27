package com.leah.thinker.io.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdeaRequest {
    private String tittle;
    private String description;
    private boolean finished;
}
