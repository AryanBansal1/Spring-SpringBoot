package repo;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface javarepo extends CrudRepository {
    JdbcTemplate jdbc;

}
