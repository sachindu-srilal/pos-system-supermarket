package lk.ijse.dep10.app.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer id;

    @NotBlank(message = "Name can't be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name")
    private String name;

    @NotBlank(message = "Address can't be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid address")
    private String address;

    @NotBlank(message = "Contact can't be empty")
    @Pattern(regexp = "^\\d{3}-\\d{7}$", message = "Invalid contact")
    private String contact;
}
