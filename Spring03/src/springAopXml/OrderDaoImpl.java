package springAopXml;
/**
* @author blw
* @version 创建时间：2019年10月30日 上午9:17:44
* 类说明
*/
public class OrderDaoImpl implements OrderDao {

	public void save() {
		System.out.println("保存订单...");
	}

	public void find() {
		System.out.println("查询订单...");
		int i=1/0;
	}

}
