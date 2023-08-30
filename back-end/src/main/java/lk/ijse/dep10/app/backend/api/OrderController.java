package lk.ijse.dep10.app.backend.api;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    @PostMapping
    public Integer saveOrder(){
        return 001;
    }

    @GetMapping
    public String getOrder(){
        return "<h1>Order</h1>";
    }
}
