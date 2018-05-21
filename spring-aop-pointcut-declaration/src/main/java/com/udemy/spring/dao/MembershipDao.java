package com.udemy.spring.dao;

import com.udemy.spring.model.Account;
import org.springframework.stereotype.Component;

/**
 * @author alexander.shakhov on 18.05.2018 18:55
 */
@Component
public class MembershipDao {

    public void addSillyAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'M GOING TO SLEEP NOW...");
    }

}
