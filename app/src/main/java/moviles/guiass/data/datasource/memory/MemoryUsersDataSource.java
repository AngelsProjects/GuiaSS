package moviles.guiass.data.datasource.memory;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import moviles.guiass.data.models.User;
import moviles.guiass.utils.UserCriteria;

public class MemoryUsersDataSource implements IMemoryUsersDataSource {
    private static HashMap<Integer, User> mCachedUsers;

    @Override
    public List<User> find(UserCriteria criteria) {
        ArrayList<User> users =
                Lists.newArrayList(mCachedUsers.values());
        return criteria.match(users);
    }

    @Override
    public void save(User user) {
        if (mCachedUsers == null) {
            mCachedUsers = new LinkedHashMap<>();
        }
        mCachedUsers.put(user.getNoControl(), user);
    }

    @Override
    public void deleteAll() {
        if (mCachedUsers == null) {
            mCachedUsers = new LinkedHashMap<>();
        }
        mCachedUsers.clear();
    }

    @Override
    public boolean mapIsNull() {
        return mCachedUsers == null;
    }
}
