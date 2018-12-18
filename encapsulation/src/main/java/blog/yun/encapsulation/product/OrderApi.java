package blog.yun.encapsulation.product;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderApi {

    private final OrderRepository orderRepository;

    public OrderApi(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order create(@RequestBody @Valid OrderRequest request) {
        final Order order = Order.builder().message(Message.of(request.getMessageType())).build();
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable long id) {
        return orderRepository.findById(id).get();
    }

}
