package com.prm.group6.services.implement;
import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.Favourite;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.FavouriteRepository;
import com.prm.group6.services.FavouriteService;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class FavouriteServiceImpl implements FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    JwtService jwtService;
    @Override
    public List<BookDTO> getFavouriteList(String token) {
        Account acc = jwtService.getAccount(token);
        List<BookDTO> favouriteBookList = new ArrayList<>();
        List<Favourite> favouriteList = favouriteRepository.findAllByAccountAccountId(acc.getAccountId());
        favouriteList.forEach(favourite -> {
            BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDto(favourite.getBook());
            favouriteBookList.add(bookDTO);
            }
        );
        return favouriteBookList;
    }

    @Override
    public List<BookDTO> addFavourite(String token, int bookId) {
        Account acc = jwtService.getAccount(token);
        Book book = bookRepository.findByBookId(bookId);
        Favourite favourite = favouriteRepository.findByAccount_AccountIdAndBook_BookId(acc.getAccountId(),bookId);
        if (favourite==null){
            favourite = new Favourite();
            favourite.setBook(book);
            favourite.setAccount(acc);
            favouriteRepository.save(favourite);
        }
        return getFavouriteList(token);
    }

    @Override
    public List<BookDTO> removeFavourite(String token, int bookId) {
        Account acc = jwtService.getAccount(token);
        Favourite favourite = favouriteRepository.findByAccount_AccountIdAndBook_BookId(acc.getAccountId(),bookId);
        favouriteRepository.delete(favourite);
        return getFavouriteList(token);
    }

}
