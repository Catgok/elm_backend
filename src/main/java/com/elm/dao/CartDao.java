package com.elm.dao;
import java.util.List;
import com.elm.po.Cart;
public interface CartDao {
    public int saveCart(Cart cart) throws Exception;
    public int updateCart(Cart cart) throws Exception;
    public int removeCart(Cart cart) throws Exception;
    public List<Cart> listCart(Cart cart) throws Exception;
}