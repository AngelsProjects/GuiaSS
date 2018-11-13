package moviles.guiass.data.datasource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import moviles.guiass.data.datasource.cloud.ICloudDocumentsDataSource;
import moviles.guiass.data.datasource.memory.IMemoryDocumentsDataSource;
import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;

import static com.google.common.base.Preconditions.checkNotNull;

public class DocumentsRepository implements IDocumentsRepository {

    private final IMemoryDocumentsDataSource mMemoryDocumentsDataSource;
    private final ICloudDocumentsDataSource mCloudDocumentsDataSource;
    private final Context mContext;

    private boolean mReload;

    public DocumentsRepository(IMemoryDocumentsDataSource memoryDataSource,
                               ICloudDocumentsDataSource cloudDataSource,
                               Context context) {
        mMemoryDocumentsDataSource = checkNotNull(memoryDataSource);
        mCloudDocumentsDataSource = checkNotNull(cloudDataSource);

        mContext = checkNotNull(context);
    }

    @Override
    public void getDocuments(GetDocumentsCallback callback, final DocumentCriteria criteria) {
        if (true) {
            getDocumentsFromServer(callback, criteria);
        } else {
            List<Document> documents = mMemoryDocumentsDataSource.find(criteria);
            if (documents.size() > 0) {
                callback.onDocumentsLoaded(documents);
            } else {
                getDocumentsFromServer(callback, criteria);
            }
        }
    }

    @Override
    public void refreshDocuments() {
        mReload = true;
    }

    private void getDocumentsFromMemory(GetDocumentsCallback callback,
                                        DocumentCriteria criteria) {

        callback.onDocumentsLoaded(mMemoryDocumentsDataSource.find(criteria));
    }

    private void getDocumentsFromServer(final GetDocumentsCallback callback,
                                        final DocumentCriteria criteria) {

        if (!isOnline()) {
            callback.onDataNotAvailable("No hay conexión de red.");
            return;
        }

        mCloudDocumentsDataSource.getDocuments(
                new ICloudDocumentsDataSource.DocumentServiceCallback() {
                    @Override
                    public void onLoaded(List<Document> documents) {
                        refreshMemoryDataSource(documents);
                        getDocumentsFromMemory(callback, criteria);
                    }

                    @Override
                    public void onError(String error) {
                        callback.onDataNotAvailable(error);
                    }
                },
                null);
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    private void refreshMemoryDataSource(List<Document> documents) {
        mMemoryDocumentsDataSource.deleteAll();
        for (Document document : documents) {
            mMemoryDocumentsDataSource.save(document);
        }
        mReload = false;
    }

}
