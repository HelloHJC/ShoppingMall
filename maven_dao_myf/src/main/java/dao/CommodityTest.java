package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.CommodityType;

import java.util.Collections;

public class CommodityTest {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        CommodityTypeDao dao=ctx.getBean(CommodityTypeDao.class);
        for (CommodityType type:dao.selectAll(null)) {
            System.out.println(type.getCommodityType_Name());
        }
    }
}
