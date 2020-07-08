import edu.etime.xsjsc.dao.GoodsTypeMapper;
import edu.etime.xsjsc.pojo.GoodsType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class testGoodsType {
    public static void main(String[] args){
        SqlSessionFactory factory = createSqlsessionFactory();
        SqlSession session = factory.openSession();
        GoodsTypeMapper mapper = session.getMapper(GoodsTypeMapper.class);
        GoodsType gt = mapper.selectByPrimaryKey("1");
        System.out.println(gt);


    }
    public static SqlSessionFactory createSqlsessionFactory() {
        SqlSessionFactory factory = null;
        String resource = "mybatis-config.xml";
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factory;
    }
}
