package com.udemy.spring;

import com.udemy.spring.config.ConfigAop;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.dao.MembershipDao;
import com.udemy.spring.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author alexander.shakhov on 18.05.2018 18:10
 */
public class MainApp {
	public static void main(String[] args) {

		// read com.udemy.spring.spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigAop.class);

		// get the bean from com.udemy.spring.spring container
		AccountDao theAccountDAO = context.getBean("accountDao", AccountDao.class);

		// get membership bean from com.udemy.spring.spring container
		MembershipDao theMembershipDAO =
				context.getBean("membershipDao", MembershipDao.class);

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyAccount();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();
	}
}
