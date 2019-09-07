
public class MobileCard {
	private String cardNumber;               //����
    private String userName;                //�û���
    private String passWord;               //����
    private ServicePackage serPackage;    //�ƶ��������ײ�
    private double consumAmount;          //�������ѽ��
    private double money;                 //�������
    private int realTalkTime;            //����ʵ��ͨ��ʱ��
    private int realSMSCount;            //����ʵ�ʷ��Ͷ�������
    private int realFlow;                //����ʵ����������

    public MobileCard() {
        //super();
    }

    //������ע���ƶ����û������ƣ����ֻ��ţ�����
    public MobileCard(String cardNumber, String userName, String passWord){
        this.cardNumber=cardNumber;
        this.userName=userName;
        this.passWord=passWord;
    }

    public MobileCard(String cardNumber, String userName, String passWord,
                      ServicePackage serPackage, double consumAmount, double money,
                      int realTalkTime, int realSMSCount, int realFlow) {
        //super();
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.serPackage = serPackage;
        this.consumAmount = consumAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    /**
     * ��ʾ�ƶ�������Ϣ
     */
    public void showMeg(){

    }
}