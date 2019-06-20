
import java.io.IOException;
import java.util.Scanner;

/**
 * 业务类
 */
class SosoMgr {
    Scanner input = new Scanner(System.in);

    /**
     * 实现主菜单
     */
    public void mainMenu() throws IOException {
        String number = "";
        boolean flag = true;

        do {
            System.out.println("*****************欢迎使用嗖嗖移动业务大厅***************");
            System.out.println("***********          1.用户登录              ***********");
            System.out.println("***********          2.用户注册              ***********");
            System.out.println("***********          3.使用嗖嗖              ***********");
            System.out.println("***********          4.话费充值              ***********");
            System.out.println("***********          5.资费说明              ***********");
            System.out.println("***********          6.客户咨询              ***********");
            System.out.println("***********          7.退出系统              ***********");
            System.out.println("*****************国庆钜惠走过路过不要错过***************");
            System.out.print("请输入功能编号：");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("*****************************《用户登录》*****************************");
                    System.out.print("请输入您的手机号：");
                    number = input.next();
                    if (number.length() == 11) {
                        System.out.print("请输入您的密码：");
                        String passWord = input.next();
                        //通过手机号和密码判断该用户是否存在
                        if (CardUtil.isExistCard(number, passWord)) {
                            cardMenu(number);
                        }
                        flag = true;
                    } else {
                        System.out.println("您输入的手机号码格式不正确!");
                    }
                    break;
                case 2:
                    System.out.println("*****************************《用户注册》*****************************");
                    registCard();

                    flag = true;
                    break;
                case 3:
                    System.out.println("*****************************《使用嗖嗖》*****************************");
                    flag = true;
                    break;
                case 4:
                    System.out.println("*****************************《话费充值》*****************************");
                    System.out.println("请输入充值手机号码：");
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
                    System.out.println("*****************************《客户咨询》*****************************");
                    //客户咨询功能未实现，可在CardUtil类写出ask方法来实现
                    //CardUtil.ask()
                    flag = true;
                    break;
                case 7:
                    System.out.println("*****************************《退出系统》*****************************");
                    System.out.println("谢谢使用");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入！");
                    flag = true;
                    break;
            }
        } while (flag);
    }


    /**
     * 二级菜单
     */
    public void cardMenu(String number) {
        boolean flag = true;
        while (flag) {
            System.out.println("*****************************嗖嗖移动用户菜单*****************************");
            System.out.println("1.本月账单查询");
            System.out.println("2.套餐余量查询");
            System.out.println("3.打印消费详单");
            System.out.println("4.套餐变更");
            System.out.println("5办理退网");
            System.out.println("请选择（输入1~5选择功能，其它键返回上一级）：");
            //num定义为String类型可以防止输入数字过大而导致的InputMismatchException异常
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("*****************************《本月账单查询》*****************************");
                    CardUtil.showAmountDetail(number);
                    flag = true;
                    break;
                case 2:
                    System.out.println("*****************************《套餐余量查询》*****************************");
                    CardUtil.showRemainDetail(number);
                    flag = true;
                    break;
                case 3:
                    System.out.println("*****************************《打印消费详情》*****************************");
                    CardUtil.printAmountDetail(number);
                    flag = true;
                    break;
                case 4:
                    System.out.println("*****************************《套餐变更》*****************************");
                    CardUtil.changingPack(number);
                    flag = true;
                    break;
                case 5:
                    System.out.println("*****************************《办理退网》*****************************");
                    CardUtil.delCard(number);
                    flag = true;
                    break;
                default:
                    flag = false;
                    break;
            }
            if (flag) {
                System.out.print("输入0返回上一层,输入其他键返回首页：");
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
     * 用户注册
     */
    public void registCard() {
        MobileCard mobileCard = new MobileCard();
        System.out.println("***************************可选择的手机号码***************************");
        //通过循环遍历输出卡号，要输出10个号码
        String[] cardNumbers = CardUtil.getNewNumbers(9);
        for (int i = 0; i < cardNumbers.length; i++) {
            System.out.print((i + 1) + "." + cardNumbers[i] + "\t");
            if (2 == i || 5 == i || 8 == i) {
                System.out.println();
            }
        }
        System.out.print("请选择卡号：");
        while (true) {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt() == true) {
                int num = input.nextInt();
                if (0 < num && num < 10) {
                    mobileCard.setCardNumber(cardNumbers[num - 1]);
                    break;
                } else {
                    System.out.print("输入错误！请输入（1~9）的数字:");
                    continue;
                }
            } else {
                System.out.print("输入错误！请输入（1~9）的整数:");
                continue;
            }
        }
        System.out.println("1.话唠套餐  2.网虫套餐  3.超人套餐 ， 请选择套餐（输入序号）:");
        boolean bol = true;
        while (bol) {
            //core定义为String类型可以防止输入数字过大而导致的InputMismatchException异常
            int core = input.nextInt();
            switch (core) {
                case 1:
                    //从此段注释开始，Case1、Case2、Case3 是相同代码块，只有变量不同
                    //提取出去写成方法在Case直接调用，无法正确获取注册的手机号码
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("请输入姓名：");
                    String userName = input.next();
                    mobileCard.setUserName(userName);
                    System.out.println("请输入密码：");
                    String passWord = input.next();
                    mobileCard.setPassWord(passWord);
                    System.out.println("请输入预存话费：");
                    int money = input.nextInt();
                    mobileCard.setMoney(money);
                    System.out.println("注册成功！手机号：" + mobileCard.getCardNumber() + ",用户名：" + mobileCard.getUserName() +
                            ",当前余额为：" + mobileCard.getMoney() + "元");
                    //到此段注释结束


                    //把注册的值给集合
                    MobileCard newmobileCard = new MobileCard(mobileCard.getCardNumber(), mobileCard.getUserName(), mobileCard.getPassWord(), Common.talkPackage, money, money, money, money, money);
                    CardUtil.addCard(newmobileCard);
                    bol = false;
                    break;
                case 2:
                    //从此段注释开始，Case1、Case2、Case3 是相同代码块，只有变量不同
                    //提取出去写成方法在Case直接调用，无法正确获取注册的手机号码
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("请输入姓名：");
                    String userName2 = input.next();
                    mobileCard.setUserName(userName2);
                    System.out.println("请输入密码：");
                    String passWord2 = input.next();
                    mobileCard.setPassWord(passWord2);
                    System.out.println("请输入预存话费：");
                    int money2 = input.nextInt();
                    mobileCard.setMoney(money2);
                    System.out.println("注册成功！手机号：" + mobileCard.getCardNumber() + ",用户名：" + mobileCard.getUserName() +
                            ",当前余额为：" + mobileCard.getMoney() + "元");
                    //到此段注释结束


                    //把注册的值给集合
                    MobileCard newmobileCard2 = new MobileCard(mobileCard.getCardNumber(), mobileCard.getUserName(), mobileCard.getPassWord(), Common.netPackage, money, money, money, money, money);
                    CardUtil.addCard(newmobileCard2);
                    bol = false;
                    break;
                case 3:
                    //从此段注释开始，Case1、Case2、Case3 是相同代码块，只有变量不同
                    //提取出去写成方法在Case直接调用，无法正确获取注册的手机号码
                    mobileCard.setSerPackage(Common.superPackage);
                    System.out.println("请输入姓名：");
                    String userName3 = input.next();
                    mobileCard.setUserName(userName3);
                    System.out.println("请输入密码：");
                    String passWord3 = input.next();
                    mobileCard.setPassWord(passWord3);
                    System.out.println("请输入预存话费：");
                    int money3 = input.nextInt();
                    mobileCard.setMoney(money3);
                    System.out.println("注册成功！手机号：" + mobileCard.getCardNumber() + ",用户名：" + mobileCard.getUserName() +
                            ",当前余额为：" + mobileCard.getMoney() + "元");
                    //到此段注释结束

                    //把注册的值给集合
                    MobileCard newmobileCard3 = new MobileCard(MobileCard.getCardNumber(), MobileCard.getUserName(), MobileCard.getPassWord(), Common.superPackage);
                    Common commom=new Common();
                    CardUtil.addCard(newmobileCard3);
                    bol = false;
                    break;
                default:
                    System.out.println("输入错误，请重新选择：");
                    bol = true;
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //给MobMobileCard的带参方法传入相应的值
        MobileCard mobileCard = new MobileCard("36949889123", "张余生", "123",
                Common.talkPackage, 0, 100, 0, 0, 0);
        MobileCard mobileCard2 = new MobileCard("12345678912", "飙车司机王", "123",
                Common.superPackage, 0, 100, 200, 100, 1);


        //把这些值传给CardUtil方法里会进入集合
        CardUtil.addCard(mobileCard);
        CardUtil.addCard(mobileCard2);
        SosoMgr sosoMgr = new SosoMgr();
        sosoMgr.mainMenu();
    }
}