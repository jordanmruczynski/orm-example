package pl.jordanmruczynski.ormexample3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.jordanmruczynski.ormexample3.controler.dto.OrderDto;
import pl.jordanmruczynski.ormexample3.repository.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select new pl.jordanmruczynski.ormexample3.controler.dto.OrderDto(sum(product.price), client.clientName, invoice.date) " +
            "from Client client " +
            "join client.invoice invoice " +
            "join invoice.product product group by client.clientName")
    List<OrderDto> getAllOrders();
}