package com.cursospring.libraryapi.service;

import com.cursospring.libraryapi.api.dto.LoanFilterDTO;
import com.cursospring.libraryapi.api.resource.BookController;
import com.cursospring.libraryapi.model.entity.Book;
import com.cursospring.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoanService {
    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoansByBook(Book book, Pageable pageable);
}
