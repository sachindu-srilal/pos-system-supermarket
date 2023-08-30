package lk.ijse.dep10.app.backend.api;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/v1/items")
@RestController
public class ItemController {

    @PatchMapping(value = "/{itemCode}", consumes = "application/json")
    public void updateItem(){
        System.out.println("updated");
    }

    @PostMapping(consumes = "application/json")
    public void saveItem(){
        System.out.println("saved");
    }

    @DeleteMapping("/{itemCode}")
    public void deleteItem(){
        System.out.println("deleted");
    }

    @GetMapping
    public String getItem(){
        return "<h1>Get item</h1>";
    }
}
