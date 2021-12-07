package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book item1 = new Book("С. Кинг");
    private Book item2 = new Book("Д. Глуховский");
    private Book item3 = new Book("Дж. Р.Р. Толкиен");
    private Book item4 = new Book("Джордж Мартин");
    private Smartphone item5 = new Smartphone("Sony");
    private Smartphone item6 = new Smartphone("BQ");
    private Smartphone item7 = new Smartphone("OPPO");
    private Smartphone item8 = new Smartphone("Nokia");


    @Test
    void shouldEmptyBasket() {
        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem() {
        repository.save(item2);
        Product[] expected = new Product[]{item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveSomeItems() {
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        Product[] expected = new Product[]{item3, item4, item5, item6};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}