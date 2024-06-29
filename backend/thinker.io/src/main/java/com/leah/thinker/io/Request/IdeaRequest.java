package com.leah.thinker.io.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdeaRequest {
    private String tittle;
    private String description;
    private boolean finished;
}
