package br.com.blsdev.services;

import br.com.blsdev.converter.DozerConverter;
import br.com.blsdev.data.vo.PersonVO;
import br.com.blsdev.exception.ResourceNotFoundException;
import br.com.blsdev.data.model.Person;
import br.com.blsdev.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO personVO) {
        var entity = DozerConverter.parserObject(personVO, Person.class);
        return DozerConverter.parserObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO personVO) {
        var entity = repository
                .findById(personVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        return DozerConverter.parserObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public PersonVO findById(Long id) {
        var entity = repository
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerConverter.parserObject(repository.save(entity), PersonVO.class);
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parserListObjects(repository.findAll(), PersonVO.class);
    }

}
