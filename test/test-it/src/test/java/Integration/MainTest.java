package Integration;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;

import static org.urbcomp.start.db.test.GetCases.*;

public class MainTest {

    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean a = true;

    /**
     * 1. 首先拿到所有的 sql用例 case文件
     * 2. 遍历每一个文件中的  case 标签
     * 3. 遍历参数, 将参数与sql拼接, 然后执行拼接后的sql
     * 4. 获取参数对应的预期值
     * 5. 实际结果与预期值进行比较
     *
     * */

    @Test
    public void allSQLCaseTest() {
        // todo 执行全部xml文件
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();   // 拿到所有的 sql用例 文件的路径
        for (String sqlCaseXML : sqlCaseXMLs) { // 遍历每一个文件中的 case 标签
            SAXReader saxReader = new SAXReader();  // 创建解析器对象
            try {
                Document document = saxReader.read(sqlCaseXML); // 创建文档对象
                Element rootElement = document.getRootElement();    // 获取根节点标签

            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void singleSQLCaseTest() {
        // todo 执行指定的xml文件

    }

}
