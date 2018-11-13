package moviles.guiass.data.datasource.memory;

import java.util.List;

import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;

public interface IMemoryDocumentsDataSource {

    List<Document> find(DocumentCriteria criteria);

    void save(Document document);

    void deleteAll();

    boolean mapIsNull();

}
