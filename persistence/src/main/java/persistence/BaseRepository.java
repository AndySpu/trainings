package persistence;

import persistence.model.Master;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BaseRepository {

    List<Master> findAllOrderedByName();

}
