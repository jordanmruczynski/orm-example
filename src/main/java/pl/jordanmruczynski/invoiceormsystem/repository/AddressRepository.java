package pl.jordanmruczynski.ormexample3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jordanmruczynski.ormexample3.repository.entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
