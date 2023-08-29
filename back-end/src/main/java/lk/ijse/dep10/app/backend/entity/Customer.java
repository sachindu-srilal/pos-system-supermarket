package lk.ijse.dep10.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements SuperEntity{
    private int id;
    private String name;
    private String address;
    private String contact;

    public Customer(String name, String address, String contact) { //AUTO_INCREMENT of id
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
