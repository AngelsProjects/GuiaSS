package moviles.guiass.di;

import android.content.Context;
import android.support.annotation.NonNull;

import moviles.guiass.data.datasource.DocumentsRepository;
import moviles.guiass.data.datasource.cloud.CloudDocumentsDataSource;
import moviles.guiass.data.datasource.memory.MemoryDocumentsDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class DependencyProvider {

    private static Context mContext;
    private static MemoryDocumentsDataSource memorySource = null;
    private static CloudDocumentsDataSource cloudSource = null;
    private static DocumentsRepository mDocumentsRepository = null;

    private DependencyProvider() {
    }

    public static DocumentsRepository provideDocumentsRepository(@NonNull Context context) {
        mContext = checkNotNull(context);
        if (mDocumentsRepository == null) {
            mDocumentsRepository = new DocumentsRepository(getMemorySource(),
                    getCloudSource(), context);
        }
        return mDocumentsRepository;
    }

    public static MemoryDocumentsDataSource getMemorySource() {
        if (memorySource == null) {
            memorySource = new MemoryDocumentsDataSource();
        }
        return memorySource;
    }

    public static CloudDocumentsDataSource getCloudSource() {
        if (cloudSource == null) {
            cloudSource = new CloudDocumentsDataSource();
        }
        return cloudSource;
    }
}
