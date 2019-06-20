
import java.io.IOException;
import java.util.Scanner;

/**
 * ҵ����
 */
class SosoMgr {
    Scanner input = new Scanner(System.in);

    /**
     * ʵ�����˵�
     */
    public void mainMenu() throws IOException {
        String number = "";
        boolean flag = true;

        do {
            System.out.println("*****************��ӭʹ�����ƶ�ҵ�����***************");
            System.out.println("***********          1.�û���¼              ***********");
            System.out.println("***********          2.�û�ע��              ***********");
            System.out.println("***********          3.ʹ����              ***********");
            System.out.println("***********          4.���ѳ�ֵ              ***********");
            System.out.println("***********          5.�ʷ�˵��              ***********");
            System.out.println("***********          6.�ͻ���ѯ              ***********");
            System.out.println("***********          7.�˳�ϵͳ              ***********");
            System.out.println("*****************�����һ��߹�·����Ҫ���***************");
            System.out.print("�����빦�ܱ�ţ�");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("*****************************���û���¼��*****************************");
                    System.out.print("�����������ֻ��ţ�");
                    number = input.next();
                    if (number.length() == 11) {
                        System.out.print("�������������룺");
                        String passWord = input.next();
                        //ͨ���ֻ��ź������жϸ��û��Ƿ����
                        if (CardUtil.isExistCard(number, passWord)) {
                            cardMenu(number);
                        }
                        flag = true;
                    } else {
                        System.out.println("��������ֻ������ʽ����ȷ!");
                    }
                    break;
                case 2:
                    System.out.println("*****************************���û�ע�ᡷ*****************************");
                    registCard();

                    flag = true;
                    break;
                case 3:
                    System.out.println("*****************************��ʹ���ಡ�*****************************");
                    flag = true;
                    break;
                case 4:
                    System.out.println("*****************************�����ѳ�ֵ��*****************************");
                    System.out.println("�������ֵ�ֻ����룺");
                    String refill_Number = input.next();
                    if (CardUtil.isExistCard(refill_Number)) {
                        CardUtil.chargeMoney(refill_Number);
                    }

                    flag = true;
                    break;
                case 5:
                    CardUtil.introduce();
                    flag = true;
                    break;
                case 6:
                    System.out.println("*****************************���ͻ���ѯ��*****************************");
                    //�ͻ���ѯ����δʵ�֣�����CardUtil��д��ask������ʵ��
                    //CardUtil.ask()
                    flag = true;
                    break;
                case 7:
                    System.out.println("*****************************���˳�ϵͳ��*****************************");
                    System.out.println("ллʹ��");
                    flag = false;
                    break;
                default:
                    System.out.println("�������,���������룡");
                    flag = true;
                    break;
            }
        } while (flag);
    }


    /**
     * �����˵�
     */
    public void cardMenu(String number) {
        boolean flag = true;
        while (flag) {
            System.out.println("*****************************���ƶ��û��˵�*****************************");
            System.out.println("1.�����˵���ѯ");
            System.out.println("2.�ײ�������ѯ");
            System.out.println("3.��ӡ�����굥");
            System.out.println("4.�ײͱ��");
            System.out.println("5��������");
            System.out.println("��ѡ������1~5ѡ���ܣ�������������һ������");
            //num����ΪString���Ϳ��Է�ֹ�������ֹ�������µ�InputMismatchException�쳣
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("*****************************�������˵���ѯ��*****************************");
                    CardUtil.showAmountDetail(number);
                    flag = true;
                    break;
                case 2:
                    System.out.println("*****************************���ײ�������ѯ��*****************************");
                    CardUtil.showRemainDetail(number);
                    flag = true;
                    break;
                case 3:
                    System.out.println("*****************************����ӡ�������顷*****************************");
                    CardUtil.printAmountDetail(number);
                    flag = true;
                    break;
                case 4:
                    System.out.println("*****************************���ײͱ����*****************************");
                    CardUtil.changingPack(number);
                    flag = true;
                    break;
                case 5:
                    System.out.println("*****************************������������*****************************");
                    CardUtil.delCard(number);
                    flag = true;
                    break;
                default:
                    flag = false;
                    break;
            }
            if (flag) {
                System.out.print("����0������һ��,����������������ҳ��");
                int strNum = input.nextInt();
                if (strNum == 1) {
                    continue;
                } else {
                    flag = false;
                }
            }
        }
    }

    /**
     * �û�ע��
     */
    public void registCard() {
        MobileCard mobileCard = new MobileCard();
        System.out.println("***************************��ѡ����ֻ�����***************************");
        //ͨ��ѭ������������ţ�Ҫ���10������
        String[] cardNumbers = CardUtil.getNewNumbers(9);
        for (int i = 0; i < cardNumbers.length; i++) {
            System.out.print((i + 1) + "." + cardNumbers[i] + "\t");
            if (2 == i || 5 == i || 8 == i) {
                System.out.println();
            }
        }
        System.out.print("��ѡ�񿨺ţ�");
        while (true) {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt() == true) {
                int num = input.nextInt();
                if (0 < num && num < 10) {
                    mobileCard.setCardNumber(cardNumbers[num - 1]);
                    break;
                } else {
                    System.out.print("������������루1~9��������:");
                    continue;
                }
            } else {
                System.out.print("������������루1~9��������:");
                continue;
            }
        }
        System.out.println("1.�����ײ�  2.�����ײ�  3.�����ײ� �� ��ѡ���ײͣ�������ţ�:");
        boolean bol = true;
        while (bol) {
            //core����ΪString���Ϳ��Է�ֹ�������ֹ�������µ�InputMismatchException�쳣
            int core = input.nextInt();
            switch (core) {
                case 1:
                    //�Ӵ˶�ע�Ϳ�ʼ��Case1��Case2��Case3 ����ͬ����飬ֻ�б�����ͬ
                    //��ȡ��ȥд�ɷ�����Caseֱ�ӵ��ã��޷���ȷ��ȡע����ֻ�����
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("������������");
                    String userName = input.next();
                    mobileCard.setUserName(userName);
                    System.out.println("���������룺");
                    String passWord = input.next();
                    mobileCard.setPassWord(passWord);
                    System.out.println("������Ԥ�滰�ѣ�");
                    int money = input.nextInt();
                    mobileCard.setMoney(money);
                    System.out.println("ע��ɹ����ֻ��ţ�" + mobileCard.getCardNumber() + ",�û�����" + mobileCard.getUserName() +
                            ",��ǰ���Ϊ��" + mobileCard.getMoney() + "Ԫ");
                    //���˶�ע�ͽ���


                    //��ע���ֵ������
                    MobileCard newmobileCard = new MobileCard(mobileCard.getCardNumber(), mobileCard.getUserName(), mobileCard.getPassWord(), Common.talkPackage, money, money, money, money, money);
                    CardUtil.addCard(newmobileCard);
                    bol = false;
                    break;
                case 2:
                    //�Ӵ˶�ע�Ϳ�ʼ��Case1��Case2��Case3 ����ͬ����飬ֻ�б�����ͬ
                    //��ȡ��ȥд�ɷ�����Caseֱ�ӵ��ã��޷���ȷ��ȡע����ֻ�����
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("������������");
                    String userName2 = input.next();
                    mobileCard.setUserName(userName2);
                    System.out.println("���������룺");
                    String passWord2 = input.next();
                    mobileCard.setPassWord(passWord2);
                    System.out.println("������Ԥ�滰�ѣ�");
                    int money2 = input.nextInt();
                    mobileCard.setMoney(money2);
                    System.out.println("ע��ɹ����ֻ��ţ�" + mobileCard.getCardNumber() + ",�û�����" + mobileCard.getUserName() +
                            ",��ǰ���Ϊ��" + mobileCard.getMoney() + "Ԫ");
                    //���˶�ע�ͽ���


                    //��ע���ֵ������
                    MobileCard newmobileCard2 = new MobileCard(mobileCard.getCardNumber(), mobileCard.getUserName(), mobileCard.getPassWord(), Common.netPackage, money, money, money, money, money);
                    CardUtil.addCard(newmobileCard2);
                    bol = false;
                    break;
                case 3:
                    //�Ӵ˶�ע�Ϳ�ʼ��Case1��Case2��Case3 ����ͬ����飬ֻ�б�����ͬ
                    //��ȡ��ȥд�ɷ�����Caseֱ�ӵ��ã��޷���ȷ��ȡע����ֻ�����
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("������������");
                    String userName3 = input.next();
                    mobileCard.setUserName(userName3);
                    System.out.println("���������룺");
                    String passWord3 = input.next();
                    mobileCard.setPassWord(passWord3);
                    System.out.println("������Ԥ�滰�ѣ�");
                    int money3 = input.nextInt();
                    mobileCard.setMoney(money3);
                    System.out.println("ע��ɹ����ֻ��ţ�" + mobileCard.getCardNumber() + ",�û�����" + mobileCard.getUserName() +
                            ",��ǰ���Ϊ��" + mobileCard.getMoney() + "Ԫ");
                    //���˶�ע�ͽ���

                    //��ע���ֵ������
                    MobileCard newmobileCard3 = new MobileCard(MobileCard.getCardNumber(), MobileCard.getUserName(), MobileCard.getPassWord(), Common.superPackage);
                    Common commom=new Common();
                    CardUtil.addCard(newmobileCard3);
                    bol = false;
                    break;
                default:
                    System.out.println("�������������ѡ��");
                    bol = true;
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //��MobMobileCard�Ĵ��η���������Ӧ��ֵ
        MobileCard mobileCard = new MobileCard("36949889123", "������", "123",
                Common.talkPackage, 0, 100, 0, 0, 0);
        MobileCard mobileCard2 = new MobileCard("12345678912", "쭳�˾����", "123",
                Common.superPackage, 0, 100, 200, 100, 1);


        //����Щֵ����CardUtil���������뼯��
        CardUtil.addCard(mobileCard);
        CardUtil.addCard(mobileCard2);
        SosoMgr sosoMgr = new SosoMgr();
        sosoMgr.mainMenu();
    }
}