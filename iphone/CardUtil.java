
import java.io.*;
import java.util.*;

/**
 * ������
 */
public class CardUtil {
    //��ʼ�û�����
    protected static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
    //�������Ѽ�¼�б�
    protected static Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
    //Scanner����������ķ��������õ�
    protected static Scanner input = new Scanner(System.in);

    public CardUtil() {
        //super();
    }


    /**
     * ����û�
     */
    public static void addCard(MobileCard card) {
        cards.put(card.getCardNumber(), card);
    }


    /**
     * ���ѳ�ֵ
     */
    public static void chargeMoney(String number) {
        System.out.println("������Ҫ��ֵ�Ľ��(������50Ԫ)��");
        while (true) {
            double money = 0.0;
            while (true) {
                Scanner input = new Scanner(System.in);
                if (input.hasNextDouble() == true) {
                    money = input.nextDouble();
                    break;
                } else {
                    System.out.print("�����������������:");
                }
            }
            if (money < 50) {
                System.out.println("����������50Ԫ���������룺");
                continue;
            } else {
                cards.get(number).setMoney(cards.get(number).getMoney() + money);
                System.out.println("��ֵ�ɹ�����ǰ�������Ϊ" + cards.get(number).getMoney());
                break;
            }
        }

    }

    /**
     * �ײͷ��ü��
     **/
    public static void introduce() throws IOException {
        //���ļ���ַ�谴���Լ����ļ���ַ��ʽ��д
        File file = new File("E:\\JavaLog/logs/2.txt");
        //ָ����ȡ�����ʽΪbgk(�����ȡ������������)
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("û���ҵ��ײͷ��ü���ļ�");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //�ر���
            br.close();
        }
    }


    /**
     * �����˵���ѯ
     */
    public static void showAmountDetail(String number) {
        MobileCard mobileCard = cards.get(number);
        System.out.println("���Ŀ���Ϊ��" + mobileCard.getCardNumber());
        System.out.println("�����˵����£�");
        System.out.println("�ײ��ʷѣ�" + mobileCard.getSerPackage().getPrice() + "Ԫ"
                + "\t�ϼ����ѣ�" + mobileCard.getConsumAmount() + "Ԫ"
                + "\t�˻���" + mobileCard.getMoney() + "Ԫ");
    }


    /**
     * �ײ�������ѯ
     */
    public static void showRemainDetail(String searchNumber) {
        MobileCard mobileCard = cards.get(searchNumber);
        MobileCard card;
        int remainTalkTime;
        int remainSmsCount;
        int remainFlow;

        StringBuffer meg = new StringBuffer();
        card = cards.get(searchNumber);
        meg.append("�����ֻ�������" + searchNumber + "������ʣ��:\n");
        ServicePackage pack = card.getSerPackage();
        //����ת�ͳ�������
        if (pack instanceof SuperPackage) {
            SuperPackage cardPack = (SuperPackage) pack;
            //��ѯ�ײ���ʣ���ͨ��ʱ��
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
            meg.append("ͨ��ʱ��:" + remainTalkTime + "����\n");
            //��ѯ�ײ���ʣ��Ķ�������
            remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount() ? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
            meg.append("��������:" + remainSmsCount + "��");
            //��ѯ�ײ���ʣ�������
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
            meg.append("ͨ��ʱ��:" + remainFlow + "����\n");

            System.out.println("�����ֻ�����:" + mobileCard.getCardNumber() + ",�ײ���ʣ��:");
            System.out.println("ͨ��ʱ��:" + remainTalkTime);
            System.out.println("��������:" + remainSmsCount);
            System.out.println("��������:" + remainFlow);

            //����ת�������ײ�
        } else if (pack instanceof NetPackage) {
            NetPackage cardPack = (NetPackage) pack;
            //��ѯ�ײ���ʣ�������
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
            meg.append("ͨ��ʱ��:" + remainFlow + "����\n");

            System.out.println("�����ֻ�����:" + mobileCard.getCardNumber() + ",�ײ���ʣ��:");
            System.out.println("��������:" + remainFlow);

            //����ת�ͻ���
        } else {
            TalkPackage cardPack = (TalkPackage) pack;
            //��ѯ�ײ���ʣ���ͨ��ʱ��
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
            meg.append("ͨ��ʱ��:" + remainTalkTime + "����\n");

            System.out.println("�����ֻ�����:" + mobileCard.getCardNumber() + ",�ײ���ʣ��:");
            System.out.println("ͨ��ʱ��:" + remainTalkTime);
        }
    }


    /**
     * ��ӡ�����굥--δʵ�ִ˹���
     */
    public static void printAmountDetail(String number) {
    }


    /**
     * �ײͱ��---δʵ�ִ˹���
     */
    public static void changingPack(String number) {
    }


    /**
     * ��������
     */
    public static void delCard(String number) {
        Set<String> numberKeys = cards.keySet();
        Iterator<String> it = numberKeys.iterator();
        while (it.hasNext()) {
            String numberKey = it.next();
            //����ڼ������ҵ��˺��룬��ɾ�������������
            if (numberKey.equals(number)) {
                //ɾ��
                cards.remove(numberKey);
                System.out.println("����" + number + "���������ɹ�\nллʹ�ã�");
            } else {
                System.out.println("û���ҵ������ֻ����룬�˿�ʧ�ܣ�");
            }
        }
    }

    /**
     * �����ֻ������������֤�ÿ��Ƿ��Ѿ����ƶ��û�
     * ʵ�е�½����
     */
    public static boolean isExistCard(String number, String passWord) {
        if (cards.size() != 0) {
            Set<String> numberKeys = cards.keySet();
            Iterator<String> its = numberKeys.iterator();
            while (its.hasNext()) {
                String numberKey = its.next();
                //����keyȡ����Ӧ��ֵ
                MobileCard mobileCard = cards.get(numberKey); 
                //trim()���������ӿ�ʼ�ڽ����Ŀո�
                if (number.trim().equals(numberKey.trim()) && passWord.trim().equals(mobileCard.getPassWord().trim())) {
                    System.out.println("�𾴵ġ�" + mobileCard.getUserName() + "�����Ǽ���Ա,��ϲ����½�ɹ�!\n");
                    return true;
                } else if (number.trim().equals(numberKey.trim()) == true && passWord.trim().equals(mobileCard.getPassWord().trim()) == false) {
                    System.out.println("�𾴵ġ�" + mobileCard.getUserName() + "�����Ǽ���Ա,���ź��������������~");
                    return false;
                }
            }
            System.out.println("�Բ���,����û��ע���Ա~");
            return false;
        } else {
            System.out.println("�Բ���,����û��ע���Ա~");
            return false;
        }
    }


    /**
     * �ֻ�������֤�Ƿ��Ѿ�ע��
     */
    public static boolean isExistCard(String number) {
        if (cards.size() != 0) {
            Set<String> numberKeys = cards.keySet();
            Iterator<String> its = numberKeys.iterator();
            while (its.hasNext()) {
                if (number.equals(its.next())) {
                    return true;
                }
            }
            System.out.println("�Բ���˺��뻹�����ƶ���Ա~");
            return false;
        } else {
            System.out.println("�Բ���˺��뻹�����ƶ���Ա~");
            return false;
        }
    }


    /**
     * �����������
     */
    public static String createNumber() {
        Random random = new Random();
        boolean isExist = false;
        String number = "";
        int temp = 0;
        do {
            isExist = false;
            //���ɵ��������8λ
            do {
                temp = random.nextInt(100000000);
            } while (temp < 10000000);
            //����֮ǰ��ǰ��ӡ�139��
            number = "139" + temp;
            //���Ѿ�ע����û��Ŀ��ŶԱȣ��ظ����޷�ע��
            if (cards != null) { //�۸��ж�
                Set<String> cardNumbers = cards.keySet();
                for (String cardNumber : cardNumbers) {
                    if (number.equals(cardNumber)) {
                        isExist = true;
                        break;
                    }
                }
            }


        } while (isExist);
        return number;
    }

    /**
     * ����ָ�������Ŀ����б�
     */
    public static String[] getNewNumbers(int count) {
        String[] strs = new String[count];
        for (int i = 0; i < count; i++) {
            strs[i] = createNumber();
        }
        return strs;
    }

    /**
     * ���ָ�����ŵ����Ѽ�¼
     * @param <ConsumInfo>
     * @param <consumInfos>
     */
    public static <ConsumInfo, consumInfos> void addConsumInfo(String number, ConsumInfo info) {
        if (consumInfos.containsKey(number)) {
            consumInfos.get(number).add(info);
        } else {
            List<ConsumInfo> list = new ArrayList<ConsumInfo>();
            list.add(info);
            consumInfos.put(number, list);
        }
        try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
    }
}