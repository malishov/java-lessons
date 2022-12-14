package Repositories;

import Model.Item;
import Model.Receipt;
import Model.SaleItem;
import Seeder.GlobalSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Repository {
    private List<Item> items;
    private List<Receipt> receipts;

    public Repository() {
        this.items = GlobalSeeder.generateItem(10);
        this.receipts = GlobalSeeder.generateRandomReceipts(0, this.items);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void addReceipt(String numbers) {

        List<SaleItem> saleItems = addSaleItem(numbers);



        if (saleItems.size() > 0) {
            long receiptId = GlobalSeeder.getGlobalReceiptId();
            GlobalSeeder.setGlobalReceiptId(++receiptId);
            double newPrice = GlobalSeeder.receiptPrice(saleItems);

            Receipt newReceipt = new Receipt(receiptId, newPrice, saleItems, LocalDate.now());

            receipts.add(newReceipt);
            System.out.println("New Receipt:");
            System.out.println(newReceipt);
        }

    }
    public List<SaleItem> addSaleItem(String numbers) {

        int elementId = 0;
        int count = 0;
        List<SaleItem> saleItems = new ArrayList<>();
        String[] idAndCountList = numbers.split("[^0-9]");

        for (int i = 0; i < idAndCountList.length; i++) {

            if (i % 2 > 0) {
                elementId = Integer.parseInt(idAndCountList[i - 1]); // id = i - 1
                count = Integer.parseInt(idAndCountList[i]); // count = i

                if (isExistInStock(elementId, count) > 0) {

                    Item newSalesItem = findItemById(elementId);
                    saleItems.add(new SaleItem(newSalesItem, count, newSalesItem.getPrice()));
                }
            }
        }
        return  saleItems;
    }
    public int isExistInStock(long id, int count) {

        for (Item item : items) {

            if (item.getId() == id) {

                if (item.getCount() >= count) {

                    item.setCount(item.getCount() - count);
                    return count;
                } else {
                    item.setCount(0);
                    return item.getCount();
                }
            }
        }
        return 0;
    }

    // Refunds

    public void refundItem(String input) {
        // SaleItem saleItem, long receiptId

        String[] ids = input.split("[^0-9]");
        long saleItemId = Long.parseLong(ids[0]);
        long receiptId = Long.parseLong(ids[1]);

        Receipt receipt = findReceiptById(receiptId);
        List<SaleItem> soldItems = receipt.getSoldItem();

        for (int i = 0; i < soldItems.size(); i++) {
            if (saleItemId == soldItems.get(i).getItem().getId()) {
                long itemId = soldItems.get(i).getItem().getId();
                findItemById(itemId).setCount(findItemById(itemId).getCount() + soldItems.get(i).getCount());
                soldItems.remove(i);
            }
        }
    }

    // Find

    public Item findItemById(long id) {

        for (Item item : items) {
            if(item.getId() == id)
                return item;
        }

        return null;
    }
    public Receipt findReceiptById(long id) {

        for (Receipt receipt : receipts) {
            if (receipt.getId() == id)
                return receipt;
        }

        return null;
    }


}
