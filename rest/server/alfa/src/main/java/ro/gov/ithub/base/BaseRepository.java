package ro.gov.ithub.base;

/**
 * Created by Mihnea on 11/23/16.
 */

import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T getReference(ID id);

    T update(T entity);

    Session getSession();

}
