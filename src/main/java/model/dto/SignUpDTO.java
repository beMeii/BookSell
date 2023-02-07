package model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SignUpDTO {
    private String email;
    private String password;
}
