package com.keen.dao_.test;

import com.keen.dao_.dao.ActorDAO;
import com.keen.dao_.dao.GoodsDAO;
import com.keen.dao_.domain.Goods;
import com.keen.jdbc.datasource_.Actor;
import org.junit.Test;

import java.util.List;

public class TestDAO {
    //测试ActorDAO
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        String sql = "select * from actor where id > ?";

        List<Actor> actors = actorDAO.queryMulti(sql, Actor.class, 2);
        for(Actor i : actors){
            System.out.println(i);
        }
        Actor actor = actorDAO.querySingle(sql, Actor.class, 2);
        System.out.println(actor);
        sql = "select name from actor where id = ?";
        Object o = actorDAO.queryScalar(sql,  2);
        System.out.println(o);

    }

    //测试ActorDAO
    @Test
    public void testGoodsDAO(){
        GoodsDAO goodsDAO = new GoodsDAO();
        String sql = "select * from goods where id > ?";

        List<Goods> goods = goodsDAO.queryMulti(sql, Goods.class, 0);
        for(Goods i : goods){
            System.out.println(i);
        }
        Goods good = goodsDAO.querySingle(sql, Goods.class, 1);
        System.out.println(good);
        sql = "select id from goods where id = ?";
        Object o = goodsDAO.queryScalar(sql, 2);
        System.out.println(o);

    }
}
