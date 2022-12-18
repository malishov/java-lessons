package service;

import model.Receipt;
import repo.ReceiptRepo;
import repo.impl.ReceiptRepoImpl;

import java.util.List;

public class ReceiptService {
    ReceiptRepo receiptRepo = new ReceiptRepoImpl();


    public void addReceipt(String numbers) {
        receiptRepo.addReceipt(numbers);
    }

    // Getter
    public List<Receipt> getReceipts() {
        return receiptRepo.findAllReceipt();
    }
}
