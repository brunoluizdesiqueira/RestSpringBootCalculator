package br.com.blsdev.services;

import br.com.blsdev.converter.DozerConverter;
import br.com.blsdev.converter.custom.PersonConverter;
import br.com.blsdev.data.vo.PersonVO;
import br.com.blsdev.data.vo.v2.PersonVOV2;
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

    @Autowired
    PersonConverter converter;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parserObject(person, Person.class);
        return DozerConverter.parserObject(repository.save(entity), PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        var entity = converter.convertVOToEntity(person);
        return converter.convertEntityToVO(repository.save(entity));
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
