
public class NetPackage  extends ServicePackage implements NetService {
	private int flow; //上网流量

    public NetPackage() {
        super();
    }

    public NetPackage(double price, int flow) {
        super(price);
        this.flow = flow;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    
    //使用流量---未实现此功能
    public int netPlay(int flow, MobileCard card) throws Exception {
        int temp = flow;
        return temp;
    }

    //重写套餐父类showInfo输出方法
    public void showInfo() {
    }
}
