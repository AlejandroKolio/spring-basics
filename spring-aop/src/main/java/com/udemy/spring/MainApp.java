package com.udemy.spring;

import com.udemy.spring.config.ConfigAop;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author alexander.shakhov on 18.05.2018 18:10
 */
public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigAop.class);

		AccountDao accountDao 		= context.getBean("accountDao", AccountDao.class);
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

		accountDao.addAccount();
		membershipDao.addAccount();

		context.close();
	}
}
