package pl.javastart.guestbook;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class BookEntryDao {
    private final DataSource dataSource;

    public BookEntryDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void save(BookEntry entry) {
        String sql = String.format("INSERT INTO book_entry(author, message) VALUES('%s', '%s')",
                entry.getAuthor(), entry.getMessage());
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<BookEntry> findAll() {
        String sql = "SELECT id, author, message FROM book_entry ORDER BY id DESC";
        List<BookEntry> entries = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String author = resultSet.getString("author");
                String message = resultSet.getString("message");
                entries.add(new BookEntry(author, message));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entries;
    }
}
