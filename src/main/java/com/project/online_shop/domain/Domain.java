package com.project.online_shop.domain;

import com.project.online_shop.bl.HibernateUtil;
import com.project.online_shop.entity.*;
import com.project.online_shop.service.OrdersServiceImpl;
import com.project.online_shop.service.UsersServiceImpl;
import java.util.Date;
import java.util.List;

public class Domain {

    public static void main(String[] args) {
        UsersServiceImpl usersServiceImpl = new UsersServiceImpl();
        OrdersServiceImpl ordersServiceImpl = new OrdersServiceImpl();

        Roles roles = new Roles();

        roles.setDescription_role("admin");

        Roles roles2 = new Roles();

        roles2.setDescription_role("user");

        Users users = new Users();

        users.setAddress("Penzenskaya st. 41, 75 flat");
        Date date = new Date();
        users.setBirthday(date);
        users.setEmail("qooteen@mail.ru");
        users.setFirst_name("Viktor");
        users.setLogin("qooteen");
        users.setPassword("123456");
        users.setPhone_number("89991845531");
        users.setPost_index("410049");
        users.setSecond_name("Kutin");
        users.setDiscount_id(null);
        users.setRole_id(roles);

        Users users2 = new Users();

        users2.setAddress("Beloglinskaya st. 10a");
        Date date2 = new Date();
        users2.setBirthday(date2);
        users2.setEmail("qooteen@sgu.ru");
        users2.setFirst_name("Viktor2");
        users2.setLogin("qooteen2");
        users2.setPassword("123456");
        users2.setPhone_number("89991845532");
        users2.setPost_index("410048");
        users2.setSecond_name("Kutin2");
        users2.setDiscount_id(null);
        users2.setRole_id(roles2);

        Orders orders = new Orders();

        orders.setUser_id(null);
        orders.setEmail("qooteen@mail.ru");
        orders.setAddress("Penzenskaya st. 41, 75 flat");
        orders.setPost_index("410049");
        orders.setFirst_name("Viktor");
        orders.setSecond_name("Kutin");
        orders.setPhone_number("89991845531");
        orders.setOrder_date(new Date());


        usersServiceImpl.add(users);
        usersServiceImpl.add(users2);
        ordersServiceImpl.add(orders);

        Orders o = ordersServiceImpl.getById(1L);

        List<Users> list = usersServiceImpl.getAll();

        usersServiceImpl.remove(usersServiceImpl.getById(1L));

        List<Users> list2 = usersServiceImpl.getAll();

        o.setFirst_name("vity");

        ordersServiceImpl.update(o);

        HibernateUtil.shutdown();

        System.out.println(o);

        for (Users u: list)
            System.out.println(u);

        for (Users u: list2)
            System.out.println(u);

        System.out.println(o);

    }
}
