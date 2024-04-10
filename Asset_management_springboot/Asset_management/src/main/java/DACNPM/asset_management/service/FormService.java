package DACNPM.asset_management.service;

import DACNPM.asset_management.model.ListBorrow;
import DACNPM.asset_management.repository.AccountRepository;
import DACNPM.asset_management.repository.ListBorrowRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Resource
    ListBorrowRepository listBorrowRepository;
    @Resource
    AccountRepository accountRepository;
    ListBorrow createListBorrow;

    public boolean create(ListBorrow listBorrow) {
        if (!accountRepository.existsById(listBorrow.getId().getIdAccount())) {
            return false;
        }
        if (listBorrowRepository.existsById(listBorrow.getId())) {
            listBorrow.setQuantity(listBorrow.getQuantity() + listBorrowRepository.findByIdAccountAndIdAsset(listBorrow.getId().getIdAccount(), listBorrow.getId().getIdAsset()).getQuantity());
        }
        createListBorrow = listBorrowRepository.save(listBorrow);
        if (createListBorrow == null) {
            return false;
        }
        return true;
    }
}
