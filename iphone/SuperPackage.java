
public class SuperPackage extends ServicePackage implements SendService, NetService, CallService {
	 private int talkTime; //ͨ��ʱ��
	    private int smsCount; //��������
	    private int flow; //��������

	    public SuperPackage() {
	        super();
	    }

	    public SuperPackage(double price, int talkTime, int smsCount, int flow) {
	        super(price);
	        this.talkTime = talkTime;
	        this.smsCount = smsCount;
	        this.flow = flow;
	    }

	    public int getTalkTime() {
	        return talkTime;
	    }

	    public void setTalkTime(int talkTime) {
	        this.talkTime = talkTime;
	    }

	    public int getSmsCount() {
	        return smsCount;
	    }

	    public void setSmsCount(int smsCount) {
	        this.smsCount = smsCount;
	    }

	    public int getFlow() {
	        return flow;
	    }

	    public void setFlow(int flow) {
	        this.flow = flow;
	    }

	    //ͨ��ʱ��---��ʱδʵ�־��幦��
	    public int call(int minCount, MobileCard card) throws Exception{
	        int temp = minCount;
	        return temp;
	    }


	    //ʹ��������---��ʱδʵ�־��幦��
	    public int netPlay(int flow, MobileCard card) throws Exception {
	        int temp = flow;
	        return temp;
	    }

	    
	    //���Ͷ�������---��ʱδʵ�־��幦��
	    public int send(int count, MobileCard card) throws Exception {
	        int temp = count;
	        return temp;
	    }

	    //��д�ײ͸���showInfo�������
	    public void showInfo() {
	    }
}
