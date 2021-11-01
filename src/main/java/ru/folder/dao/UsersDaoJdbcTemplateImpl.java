package ru.folder.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.folder.models.Car;
import ru.folder.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
      return new User(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"));
    };

    private Map<Integer, User> usersMap = new HashMap<>(); //я буду хранить id вместе с пользователем
    private RowMapper<User> userRowMapper1 = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id"); //id-User
        if (!usersMap.containsKey(id)) { //если не содержится такой ключ
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            User user = new User(id, firstName, lastName, new ArrayList<>());
            usersMap.put(id, user); //в HashMap под этим id положим пользователя, если есть игнорируем, нет-положим.
        }
        Car car = new Car(resultSet.getInt("id"),
                resultSet.getString("model"), usersMap.get(id));//по ключу вытащили Car

        usersMap.get(id).getCars().add(car); //у пользователя по id.берем все машины.и положить машину.

        return usersMap.get(id); //возвращаем
    };

    //language=SQL
    private final String SQL_SELECT_ALL
            = "SELECT * FROM our_user";

    //language=SQL
    private final String SQL_SELECT_USER_WITH_CAR =
            "SELECT our_user.*, user_car.id as id, user_car.model FROM our_user LEFT JOIN user_car ON our_user.id = user_car.owner_id WHERE our_user.id = ?";


    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }
}
