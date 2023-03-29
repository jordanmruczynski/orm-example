package pl.jordanmruczynski.ormexample3;

import pl.jordanmruczynski.ormexample3.repository.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    void saveInvoice(Invoice invoice);
    void deleteInvoice(Long id);
    void updateInvoice(Invoice newInvoice);

}