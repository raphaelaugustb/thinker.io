package com.leah.thinker.io.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record AccountRequest(String email, String username, String password) {
}
