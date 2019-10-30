package springAopAnno;
/**
* @author blw
* @version 创建时间：2019年10月29日 下午4:16:25
* 类说明
*/
public class OrderDao {
	
	public void save(){
		System.out.println("保存订单...");
	}
	
	public void find(){
		System.out.println("查询订单...");
		int d = 1/0;
	}

}
