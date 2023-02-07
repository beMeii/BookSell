package repositories;

import model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends JpaRepository<Account,String> {
    Boolean existsByEmail(String email);
}
