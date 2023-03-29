package pl.jordanmruczynski.ormexample3;

import org.springframework.stereotype.Service;
import pl.jordanmruczynski.ormexample3.repository.AddressRepository;
import pl.jordanmruczynski.ormexample3.repository.ClientRepository;
import pl.jordanmruczynski.ormexample3.repository.InvoiceRepository;
import pl.jordanmruczynski.ormexample3.repository.entity.Address;
import pl.jordanmruczynski.ormexample3.repository.entity.Client;
import pl.jordanmruczynski.ormexample3.repository.entity.Invoice;
import pl.jordanmruczynski.ormexample3.repository.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ClientRepository clientRepository, AddressRepository addressRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;

        // address
        Address address1 = new Address();
        address1.setStreetName("Wiosenna");

        Address address2 = new Address();
        address2.setStreetName("Zimowa");

        Address address3 = new Address();
        address3.setStreetName("Letnia");

        // product
        Product productSpringBoot2 = new Product();
        productSpringBoot2.setPrice(BigDecimal.valueOf(200));
        productSpringBoot2.setProductName("LiveBook: Spring Boot 2");

        Product productSpringBoot3 = new Product();
        productSpringBoot3.setPrice(BigDecimal.valueOf(500));
        productSpringBoot3.setProductName("LiveBook: Spring Boot 3");

        // client
        Client client1 = new Client();
        client1.setClientName("Anna");
        Client client2 = new Client();
        client2.setClientName("Adam");

        // invoice
        Invoice invoice = new Invoice();
        invoice.setDate(LocalDate.of(2022, 10, 10));
        invoice.setProduct(Set.of(productSpringBoot2, productSpringBoot3));
        invoice.setClient(client1);

        Invoice invoice2 = new Invoice();
        invoice2.setDate(LocalDate.of(2025, 10, 10));
        invoice2.setProduct(Set.of(productSpringBoot3));
        invoice2.setClient(client2);

        // save invoices
        invoiceRepository.saveAll(Arrays.asList(invoice, invoice2));

        // save addresses
        address1.setClient(client1);
        address2.setClient(client1);
        address3.setClient(client2);
        addressRepository.saveAll(Arrays.asList(address1, address2, address3));

        System.out.println(clientRepository.getAllOrders());

    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }

    @Override
    public void saveInvoice(Invoice invoice) {

    }

    @Override
    public void deleteInvoice(Long id) {
    }

    @Override
    public void updateInvoice(Invoice newInvoice) {

    }
}
