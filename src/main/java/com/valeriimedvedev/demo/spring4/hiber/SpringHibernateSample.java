package com.valeriimedvedev.demo.spring4.hiber;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringHibernateSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        Contact contact = contactDao.findById(1L);
        contactDao.delete(contact);

        listContactsWithDetail(contactDao.findAllWithDetail());
    }

    private static void listContactsWithDetail(List<Contact> contacts)
    {
        System.out.println("");
        System.out.println("Listing contacts with details:");

        for (Contact contact : contacts)
        {
            System.out.println(contact);

            if (contact.getContactTelDetails() != null)
            {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails())
                {
                    System.out.println(contactTelDetail);
                }
            }

            if (contact.getHobbies() != null)
            {
                for (Hobby hobby : contact.getHobbies())
                {
                    System.out.println(hobby);
                }
            }
        }
    }
}
