package moviles.guiass.di;

import android.content.Context;
import android.support.annotation.NonNull;

import moviles.guiass.data.datasource.DocumentsRepository;
import moviles.guiass.data.datasource.UserRepository;
import moviles.guiass.data.datasource.cloud.CloudDocumentsDataSource;
import moviles.guiass.data.datasource.cloud.CloudUsersDataSource;
import moviles.guiass.data.datasource.memory.MemoryDocumentsDataSource;
import moviles.guiass.data.datasource.memory.MemoryUsersDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class DependencyProvider {

    private static Context mDocumentsContext;
    private static MemoryDocumentsDataSource memoryDocumentsSource = null;
    private static CloudDocumentsDataSource cloudDocumentsSource = null;
    private static DocumentsRepository mDocumentsRepository = null;

    private static Context mUsersContext;
    private static MemoryUsersDataSource memoryUsersSource = null;
    private static CloudUsersDataSource cloudUsersSource = null;
    private static UserRepository mUsersRepository = null;

    private DependencyProvider() {
    }

    public static DocumentsRepository provideDocumentsRepository(@NonNull Context context) {
        mDocumentsContext = checkNotNull(context);
        if (mDocumentsRepository == null) {
            mDocumentsRepository = new DocumentsRepository(getDocumentsMemorySource(),
                    getDocumentsCloudSource(), context);
        }
        return mDocumentsRepository;
    }

    public static MemoryDocumentsDataSource getDocumentsMemorySource() {
        if (memoryDocumentsSource == null) {
            memoryDocumentsSource = new MemoryDocumentsDataSource();
        }
        return memoryDocumentsSource;
    }

    public static CloudDocumentsDataSource getDocumentsCloudSource() {
        if (cloudDocumentsSource == null) {
            cloudDocumentsSource = new CloudDocumentsDataSource();
        }
        return cloudDocumentsSource;
    }

    public static UserRepository provideUsersRepository(@NonNull Context context) {
        mUsersContext = checkNotNull(context);
        if (mUsersRepository == null) {
            mUsersRepository = new UserRepository(getUsersMemorySource(),
                    getUsersCloudSource(), context);
        }
        return mUsersRepository;
    }

    public static MemoryUsersDataSource getUsersMemorySource() {
        if (memoryUsersSource == null) {
            memoryUsersSource = new MemoryUsersDataSource();
        }
        return memoryUsersSource;
    }

    public static CloudUsersDataSource getUsersCloudSource() {
        if (cloudUsersSource == null) {
            cloudUsersSource = new CloudUsersDataSource();
        }
        return cloudUsersSource;
    }
}
