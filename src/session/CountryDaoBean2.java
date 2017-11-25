package session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.Country;

@Stateless
@Local(CountryDaoLocal.class)
public class CountryDaoBean2 extends GenericDaoBean<Country, Integer> implements
CountryDaoLocal {

}
