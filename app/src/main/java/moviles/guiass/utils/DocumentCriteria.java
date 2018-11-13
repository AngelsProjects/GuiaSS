package moviles.guiass.utils;

import java.util.List;

import moviles.guiass.data.models.Document;

public interface DocumentCriteria {
    List<Document> match(List<Document> documents);
}
