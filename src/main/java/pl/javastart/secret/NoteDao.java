package pl.javastart.secret;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

class NoteDao {
    private DataSource dataSource;

    NoteDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void save(Note note) {
        final String sql = String.format("INSERT INTO notes (title, content, pass) VALUES(?, ?, ?)",
                note.getTitle(), note.getContent(), note.getPassword());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { //1
            statement.setString(1, note.getTitle());    //2
            statement.setString(2, note.getContent());  //2
            statement.setString(3, note.getPassword()); //2
            statement.executeUpdate(); //3
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                note.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Optional<Note> findByTitleAndPassword(String title, String password) {
        final String sql = "SELECT id, title, content, pass FROM notes WHERE title = ? AND pass = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) { //1
            statement.setString(1, title);    //2
            statement.setString(2, password); //2
            ResultSet resultSet = statement.executeQuery(); //3
            if (resultSet.next()) {
                int noteId = resultSet.getInt("id");
                String noteTitle = resultSet.getString("title");
                String noteContent = resultSet.getString("content");
                String notePassword = resultSet.getString("pass");
                return Optional.of(new Note(noteId, noteTitle, noteContent, notePassword));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}