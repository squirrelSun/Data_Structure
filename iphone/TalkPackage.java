
public class TalkPackage extends ServicePackage implements CallService, SendService {
	private int talkTime;//ͨ��ʱ��
    private int smsCount;//��������

    public TalkPackage() {
        super();
    }

    public TalkPackage(double price, int talkTime, int smsCount) {
        //�Ѵ��ײ͵ļ۸񴫸�����
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


    //ͨ��ʱ��---δʵ�ִ˹���
    public int call(int minCount, MobileCard card) throws Exception {
        int temp = minCount;
        return temp;
    }

    //���Ͷ�������------δʵ�ִ˹���
    public int send(int count, MobileCard card) throws Exception {
        int temp = count;
        return temp;
    }

    //��д�ײ͸���showInfo�������
    public void showInfo() {
    }
}
