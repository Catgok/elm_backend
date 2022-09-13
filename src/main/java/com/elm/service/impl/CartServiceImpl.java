package com.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.elm.dao.CartDao;
import com.elm.dao.impl.CartDaoImpl;
import com.elm.po.Cart;
import com.elm.service.CartService;
import com.elm.util.DBUtil;

public class CartServiceImpl implements CartService {
    @Override
    public int saveCart(Cart cart) {
        int result = 0;
        CartDao dao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.saveCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int updateCart(Cart cart) {
        int result = 0;
        CartDao dao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.updateCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int removeCart(Cart cart) {
        int result = 0;
        CartDao dao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.removeCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public List<Cart> listCart(Cart cart) {
        List<Cart> list = new ArrayList();
        CartDao dao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}