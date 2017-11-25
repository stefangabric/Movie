package session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.Score;

@Stateless
@Local(ScoreDaoLocal.class)
public class ScoreDaoBean extends GenericDaoBean<Score, Integer> implements
ScoreDaoLocal {

	
}
