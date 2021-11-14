package codeplays.trainee.contactlist.controller;

import codeplays.trainee.contactlist.exception.BadRequestException;
import codeplays.trainee.contactlist.model.Contact;
import codeplays.trainee.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("phones")
    public List<Contact> findAllContacts() {
        return contactService.findAllContacts();
    }

    @PostMapping("phones")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactRequest request) {

        Contact contact = new Contact(request.getName(), request.getPhone());

        contactService.createContact(contact);
    }
    @DeleteMapping("phones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id ){
        contactService.deleteContact(id);

    }
    @PutMapping("phones/{id}")
    public void updateContact(@RequestBody ContactRequest request, @PathVariable Long id){

        Contact contact = new Contact(request.getName(), request.getPhone());
        contactService.updateContact(id, contact);

    }
    @GetMapping("phones/{id}")
    public Contact findContact(@PathVariable Long id) throws BadRequestException {
        return contactService.findContact(id);
    }
}
