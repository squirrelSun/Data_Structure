
public class NetPackage  extends ServicePackage implements NetService {
	private int flow; //��������

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

    
    //ʹ������---δʵ�ִ˹���
    public int netPlay(int flow, MobileCard card) throws Exception {
        int temp = flow;
        return temp;
    }

    //��д�ײ͸���showInfo�������
    public void showInfo() {
    }
}
