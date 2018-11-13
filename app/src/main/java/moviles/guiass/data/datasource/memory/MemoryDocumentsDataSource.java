package moviles.guiass.data.datasource.memory;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;

public class MemoryDocumentsDataSource implements IMemoryDocumentsDataSource {

    private static HashMap<Integer, Document> mCachedDocuments;

    @Override
    public List<Document> find(DocumentCriteria criteria) {
        ArrayList<Document> documents =
                Lists.newArrayList(mCachedDocuments.values());
        return criteria.match(documents);
    }

    @Override
    public void save(Document document) {
        if (mCachedDocuments == null) {
            mCachedDocuments = new LinkedHashMap<>();
        }
        mCachedDocuments.put(document.getNumber(), document);
    }

    @Override
    public void deleteAll() {
        if (mCachedDocuments == null) {
            mCachedDocuments = new LinkedHashMap<>();
        }
        mCachedDocuments.clear();
    }

    @Override
    public boolean mapIsNull() {
        return mCachedDocuments == null;
    }
}
