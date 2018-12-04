package moviles.guiass.data.datasource.memory;

import java.util.List;

import moviles.guiass.data.models.User;
import moviles.guiass.utils.UserCriteria;

public interface IMemoryUsersDataSource {
    List<User> find(UserCriteria criteria);

    void save(User user);

    void deleteAll();

    boolean mapIsNull();
}
