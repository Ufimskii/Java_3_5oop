package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "Убить Пересмешника", 630, "Ли Харпер");
    Book item2 = new Book(2, "Рассказы", 850, "Джером К. Джером");
    Book item3 = new Book(3, "Война Миров", 530, "Герберт Уэллс");
    Book item4 = new Book(4, "Повелитель мух", 450, "Уильям Голдинг");
    Smartphone item5 = new Smartphone(5, "IPhone13", 135000, "Apple");
    Smartphone item6 = new Smartphone(6, "POCO X3 Pro", 22000, "POCO");
    Smartphone item7 = new Smartphone(7, "Mi11 Ultra", 100000, "XIAOMI");
    Smartphone item8 = new Smartphone(8, "S21 Plus", 95000, "Samsung");


    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }


    @Test
    void searchByBookName() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("Война Миров");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("Джером К. Джером");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Гербер Уэлс");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("IPhone13");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy("POCO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("PCOC");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAddSomeItems() {
        Product[] expected = new Product[]{item1};
        Product[] actual = manager.searchBy("Ли Харпер");
        assertArrayEquals(expected, actual);
    }
}