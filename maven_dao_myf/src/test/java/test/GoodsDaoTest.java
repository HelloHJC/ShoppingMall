package test;

import dao.CommodityTypeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import po.CommodityType;

@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsDaoTest {
    @Autowired
    CommodityTypeDao dao;
    @Test
    public void testSelectAll()
    {
        for (CommodityType type:dao.selectAll(null)) {
            System.out.println(type.getCommdityType_Name());
        }
    }
    @Test
    public void test2()
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        CommodityTypeDao dao=ctx.getBean(CommodityTypeDao.class);
        for (CommodityType type:dao.selectAll(null)) {
            System.out.println(type.getCommdityType_Name());
        }
    }
}
