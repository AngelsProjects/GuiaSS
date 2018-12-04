package moviles.guiass.utils;

import java.util.List;

import moviles.guiass.data.models.User;

public interface UserCriteria {
    List<User> match(List<User> users);
}
