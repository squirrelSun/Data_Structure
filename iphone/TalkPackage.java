
public class TalkPackage extends ServicePackage implements CallService, SendService {
	private int talkTime;//通话时长
    private int smsCount;//短信条数

    public TalkPackage() {
        super();
    }

    public TalkPackage(double price, int talkTime, int smsCount) {
        //把此套餐的价格传给父类
        super(price);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
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


    //通话时长---未实现此功能
    public int call(int minCount, MobileCard card) throws Exception {
        int temp = minCount;
        return temp;
    }

    //发送短信数量------未实现此功能
    public int send(int count, MobileCard card) throws Exception {
        int temp = count;
        return temp;
    }

    //重写套餐父类showInfo输出方法
    public void showInfo() {
    }
}
