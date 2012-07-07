/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package ejb3.stateful.client;

import java.util.HashMap;

import javax.naming.InitialContext;

import ejb3.stateful.bean.ShoppingCart;

/**
 * Comment
 * 
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 61136 $
 */
public class Client {
    public static void main(String[] args) throws Exception {
        InitialContext ctx = new InitialContext();
        ShoppingCart cart1 = (ShoppingCart) ctx.lookup("ShoppingCartBean/remote");
        ShoppingCart cart2 = (ShoppingCart) ctx.lookup("ShoppingCartBean/remote");

        System.out.println("Buying 1 memory stick");
        cart1.buy("Memory stick", 1);
        cart2.buy("Memory stick", 1);
        System.out.println("Buying another memory stick");
        cart1.buy("Memory stick", 1);

        System.out.println("Buying a laptop");
        cart1.buy("Laptop", 1);

        System.out.println("Print cart:");
        HashMap<String, Integer> fullCart = cart1.getCartContents();
        for (String product : fullCart.keySet()) {
            System.out.println(fullCart.get(product) + "     " + product);
        }

        System.out.println("Print cart2:");
        fullCart = cart2.getCartContents();
        for (String product : fullCart.keySet()) {
            System.out.println(fullCart.get(product) + "     " + product);
        }

        System.out.println("Checkout");
        cart1.checkout();

        System.out.println("Should throw an object not found exception by invoking on cart after @Remove method");
        try {
            cart1.buy("Laptop", 1);
            cart1.getCartContents();
        } catch (javax.ejb.NoSuchEJBException e) {
            System.out.println("Successfully caught no such object exception.");
        }

    }
}
