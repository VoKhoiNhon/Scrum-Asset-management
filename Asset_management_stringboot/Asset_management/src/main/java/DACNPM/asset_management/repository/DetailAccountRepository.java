package repository;

import model.DetailAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailAccountRepository extends JpaRepository<DetailAccount,Integer> {
}
