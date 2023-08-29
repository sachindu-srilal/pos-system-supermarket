package lk.ijse.dep10.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements SuperEntity{
    private int id;
    private Timestamp datetime;

    public Order(Timestamp datetime) { //AUTO_INCREMENT id
        this.datetime = datetime;
    }
}
