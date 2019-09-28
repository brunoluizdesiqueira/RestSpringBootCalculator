package br.com.blsdev.controller;

import br.com.blsdev.converter.DozerConverter;
import br.com.blsdev.data.vo.v1.BookVO;
import br.com.blsdev.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Api(value = "Livros EndPoint", description = "Descrição do EndPoint de Livros", tags = {"Livros EndPoint", "Livros"})
@RestController
@RequestMapping("/book/v1")
public class BookController {

    @Autowired
    BookServices service;

    @ApiOperation(value = "Localizar todos os livros")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    private List<BookVO> findAll() {
        List<BookVO> books = service.findAll();
        books
                .stream()
                .forEach(b -> b.add(
                            linkTo(methodOn(BookController.class)
                                .findById(b.getKey()))
                                .withSelfRel()
                        )
                );

        return books;
    }

    @ApiOperation(value = "Localizar livro por identificador")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO findById(@PathVariable("id") long id) {
        BookVO bookVO = service.findById(id);
        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Criar novo livro")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
                 consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO create(@RequestBody BookVO book) {
        BookVO bookVO = service.crete(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Atualizar livro")
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
                consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO update(@RequestBody() BookVO book) {
        var bookVO = service.update(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Apagar livro por identificador")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
