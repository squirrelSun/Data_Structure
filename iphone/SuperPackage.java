
public class SuperPackage extends ServicePackage implements SendService, NetService, CallService {
	 private int talkTime; //通话时长
	    private int smsCount; //短信数量
	    private int flow; //上网流量

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

	    //通话时长---暂时未实现具体功能
	    public int call(int minCount, MobileCard card) throws Exception{
	        int temp = minCount;
	        return temp;
	    }


	    //使用流量数---暂时未实现具体功能
	    public int netPlay(int flow, MobileCard card) throws Exception {
	        int temp = flow;
	        return temp;
	    }

	    
	    //发送短信数量---暂时未实现具体功能
	    public int send(int count, MobileCard card) throws Exception {
	        int temp = count;
	        return temp;
	    }

	    //重写套餐父类showInfo输出方法
	    public void showInfo() {
	    }
}
