package codeplays.trainee.contactlist.service;

import codeplays.trainee.contactlist.exception.BadRequestException;
import codeplays.trainee.contactlist.model.Contact;
import codeplays.trainee.contactlist.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAllContacts() {

        return contactRepository.findAll();
    }

    public void createContact(Contact contact) {
        contactRepository.save(contact);
    }
    public void deleteContact(Long id){
        Optional<Contact> contactOptional = contactRepository.findById(id);

        contactOptional.ifPresent((contact) -> {
            contactRepository.deleteById(id);
        });
    }
    public void updateContact(Long id, Contact contact ){
        Optional<Contact> contactOptional = contactRepository.findById(id);

        contactOptional.ifPresent((c)->{
            c.setName(contact.getName());
            c.setPhone(contact.getPhone());
            contactRepository.save(c);
        });
    }
    public Contact findContact(Long id) throws BadRequestException {
       Optional<Contact> contactOptional = contactRepository.findById(id);

       return contactOptional.orElseThrow(() -> new BadRequestException("Contato não encontrado!"));
    }

}
