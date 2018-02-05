package chl.hajo.library.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A book written by some author(s)
 * Core model class
 * @author hajo
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"isbn"})
@Entity
@Table(name ="book")
public class Book implements Serializable {
    @Id
    @Setter
    @Getter
    @Column(nullable=false, unique = true)
    @Size(min = 1, max = 13)
    private String isbn;
    @Setter
    @Getter
    @Size(min = 1, max = 50)
    private String title;
    @Setter
    @Getter
    private Genre genre;
    @Setter
    @Getter
    private double price;

    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title="
                + title + ", genre=" + genre
                +  ", price=" + price + '}';
    }

}
