package br.com.blsdev.services;

import br.com.blsdev.converter.DozerConverter;
import br.com.blsdev.data.model.Book;
import br.com.blsdev.data.vo.v1.BookVO;
import br.com.blsdev.exception.ResourceNotFoundException;
import br.com.blsdev.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookRepository bookRepository;

    public BookVO crete(BookVO bookVO) {
     var entity = DozerConverter.parserObject(bookVO, Book.class);
     return DozerConverter.parserObject(bookRepository.save(entity), BookVO.class);
    }

    public BookVO update(BookVO bookVO) {
        var entity = bookRepository
                .findById(bookVO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(bookVO.getAuthor());
        entity.setLaunchDate(bookVO.getLaunchDate());
        entity.setPrice(bookVO.getPrice());
        entity.setTitle(bookVO.getTitle());

        return DozerConverter.parserObject(bookRepository.save(entity), BookVO.class);
    }

    public void delete(long id) {
        var entity = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        bookRepository.delete(entity);
    }

    public BookVO findById(long id) {
        var entity = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerConverter.parserObject(entity, BookVO.class);
    }

    public List<BookVO> findAll() {
        return DozerConverter.parserListObjects(bookRepository.findAll(), BookVO.class);
    }
}
