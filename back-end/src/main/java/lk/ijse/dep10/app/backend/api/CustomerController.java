package lk.ijse.dep10.app.backend.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @PostMapping(consumes = "application/json")
    public String saveCustomer(){
        return "<h1>Save customers </h1>";
    }

    @GetMapping
    public String getCustomers(){
        return "<h1>Get all customers </h1>";
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(){
        System.out.println("Deleted");
    }

    @PatchMapping("/{customerId}")
    public void updateCustomer(){
        System.out.println("updated");
    }
}
