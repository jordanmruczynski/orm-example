package pl.jordanmruczynski.ormexample3.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jordanmruczynski.ormexample3.InvoiceService;
import pl.jordanmruczynski.ormexample3.controler.dto.OrderDto;
import pl.jordanmruczynski.ormexample3.repository.ClientRepository;
import pl.jordanmruczynski.ormexample3.repository.entity.Invoice;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private ClientRepository clientRepository;

    public InvoiceController(InvoiceService invoiceService, ClientRepository clientRepository) {
        this.invoiceService = invoiceService;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String getAllInvoices(Model model) {
        List<OrderDto> allOrders = clientRepository.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "gui";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/";
    }

}