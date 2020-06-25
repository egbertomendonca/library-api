package com.cursospring.libraryapi.api.resource;

import com.cursospring.libraryapi.api.dto.LoanDTO;
import com.cursospring.libraryapi.model.entity.Book;
import com.cursospring.libraryapi.model.entity.Loan;
import com.cursospring.libraryapi.service.BookService;
import com.cursospring.libraryapi.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Long create(@RequestBody LoanDTO dto){
        Book book = bookService.getBookByIsbn(dto.getIsbn())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found for passed isbn"));
        Loan entity = Loan.builder()
                .book(book)
                .customer(dto.getCustomer())
                .loandate(LocalDate.now())
                .build();

        entity = service.save(entity);

        return entity.getId();
    }


}
