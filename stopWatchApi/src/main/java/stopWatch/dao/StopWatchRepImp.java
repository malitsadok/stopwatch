package stopWatch.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import stopWatch.model.TimeWatch;
@Repository
public class StopWatchRepImp  implements  StopWatchRepository{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void deleteAllTimeWatches() {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.beginTransaction() ;
	    Query query = currentSession.createQuery("delete from TimeWatch"  );
	    query.executeUpdate();
	    currentSession.getTransaction().commit();;

	}

	@Override
	public List<TimeWatch> getAllTimeWatches() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<TimeWatch> query = currentSession.createQuery("from TimeWatch", TimeWatch.class);
		List<TimeWatch> list = query.getResultList();
		return list;
	}

	@Override
	public void saveTimeWatch(TimeWatch timeWatch) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.beginTransaction() ;
		currentSession.persist(timeWatch);
		currentSession.getTransaction().commit();
		
	}

}
