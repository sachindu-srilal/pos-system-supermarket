package lk.ijse.dep10.app.backend.dto;

import lk.ijse.dep10.app.backend.dto.util.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    @NotBlank(message = "Item code can't be empty", groups = {ValidationGroups.Save.class})
    @Pattern(regexp = "\\d+", message = "Invalid item code", groups = {ValidationGroups.Save.class})
    private String code;

    @NotBlank(message = "Description can't be empty")
    private String description;

    @NotNull(message = "Qty. can't be empty or null")
    @Min(value = 0, message = "Qty. can't be negative")
    private Integer qty;

    @NotNull(message = "Unit price can't be empty or ")
    @Min(value = 0, message = "Unit price can't be negative")
    private BigDecimal unit_price;
}
