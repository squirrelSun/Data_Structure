
import java.io.*;
import java.util.*;

/**
 * 工具类
 */
public class CardUtil {
    //初始用户集合
    protected static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
    //卡号消费记录列表
    protected static Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
    //Scanner方法，后面的方法会多次用到
    protected static Scanner input = new Scanner(System.in);

    public CardUtil() {
        //super();
    }


    /**
     * 添加用户
     */
    public static void addCard(MobileCard card) {
        cards.put(card.getCardNumber(), card);
    }


    /**
     * 话费充值
     */
    public static void chargeMoney(String number) {
        System.out.println("请输入要充值的金额(不少于50元)：");
        while (true) {
            double money = 0.0;
            while (true) {
                Scanner input = new Scanner(System.in);
                if (input.hasNextDouble() == true) {
                    money = input.nextDouble();
                    break;
                } else {
                    System.out.print("输入错误！请重新输入:");
                }
            }
            if (money < 50) {
                System.out.println("输入金额少于50元请重新输入：");
                continue;
            } else {
                cards.get(number).setMoney(cards.get(number).getMoney() + money);
                System.out.println("充值成功，当前话费余额为" + cards.get(number).getMoney());
                break;
            }
        }

    }

    /**
     * 套餐费用简介
     **/
    public static void introduce() throws IOException {
        //该文件地址需按照自己的文件地址格式来写
        File file = new File("E:\\JavaLog/logs/2.txt");
        //指定读取编码格式为bgk(解决读取出现中文乱码)
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("没有找到套餐费用简介文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            br.close();
        }
    }


    /**
     * 本月账单查询
     */
    public static void showAmountDetail(String number) {
        MobileCard mobileCard = cards.get(number);
        System.out.println("您的卡号为：" + mobileCard.getCardNumber());
        System.out.println("当月账单如下：");
        System.out.println("套餐资费：" + mobileCard.getSerPackage().getPrice() + "元"
                + "\t合计消费：" + mobileCard.getConsumAmount() + "元"
                + "\t账户余额：" + mobileCard.getMoney() + "元");
    }


    /**
     * 套餐余量查询
     */
    public static void showRemainDetail(String searchNumber) {
        MobileCard mobileCard = cards.get(searchNumber);
        MobileCard card;
        int remainTalkTime;
        int remainSmsCount;
        int remainFlow;

        StringBuffer meg = new StringBuffer();
        card = cards.get(searchNumber);
        meg.append("您的手机号码是" + searchNumber + "餐套内剩余:\n");
        ServicePackage pack = card.getSerPackage();
        //向下转型超人类型
        if (pack instanceof SuperPackage) {
            SuperPackage cardPack = (SuperPackage) pack;
            //查询套餐内剩余的通话时长
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
            meg.append("通话时长:" + remainTalkTime + "分钟\n");
            //查询套餐内剩余的短信条数
            remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount() ? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
            meg.append("短信条数:" + remainSmsCount + "条");
            //查询套餐内剩余的流量
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
            meg.append("通话时长:" + remainFlow + "分钟\n");

            System.out.println("您的手机号是:" + mobileCard.getCardNumber() + ",套餐内剩余:");
            System.out.println("通话时长:" + remainTalkTime);
            System.out.println("短信条数:" + remainSmsCount);
            System.out.println("上网流量:" + remainFlow);

            //向下转型上网套餐
        } else if (pack instanceof NetPackage) {
            NetPackage cardPack = (NetPackage) pack;
            //查询套餐内剩余的流量
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
            meg.append("通话时长:" + remainFlow + "分钟\n");

            System.out.println("您的手机号是:" + mobileCard.getCardNumber() + ",套餐内剩余:");
            System.out.println("上网流量:" + remainFlow);

            //向下转型话痨
        } else {
            TalkPackage cardPack = (TalkPackage) pack;
            //查询套餐内剩余的通话时长
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
            meg.append("通话时长:" + remainTalkTime + "分钟\n");

            System.out.println("您的手机号是:" + mobileCard.getCardNumber() + ",套餐内剩余:");
            System.out.println("通话时长:" + remainTalkTime);
        }
    }


    /**
     * 打印消费详单--未实现此功能
     */
    public static void printAmountDetail(String number) {
    }


    /**
     * 套餐变更---未实现此功能
     */
    public static void changingPack(String number) {
    }


    /**
     * 办理退网
     */
    public static void delCard(String number) {
        Set<String> numberKeys = cards.keySet();
        Iterator<String> it = numberKeys.iterator();
        while (it.hasNext()) {
            String numberKey = it.next();
            //如果在集合中找到此号码，则删除他，完成退网
            if (numberKey.equals(number)) {
                //删除
                cards.remove(numberKey);
                System.out.println("卡号" + number + "办理退网成功\n谢谢使用！");
            } else {
                System.out.println("没有找到您的手机号码，退卡失败！");
            }
        }
    }

    /**
     * 根据手机号码和密码验证该卡是否已经是移动用户
     * 实行登陆操作
     */
    public static boolean isExistCard(String number, String passWord) {
        if (cards.size() != 0) {
            Set<String> numberKeys = cards.keySet();
            Iterator<String> its = numberKeys.iterator();
            while (its.hasNext()) {
                String numberKey = its.next();
                //根据key取出对应的值
                MobileCard mobileCard = cards.get(numberKey); 
                //trim()作用是无视开始于结束的空格
                if (number.trim().equals(numberKey.trim()) && passWord.trim().equals(mobileCard.getPassWord().trim())) {
                    System.out.println("尊敬的☆" + mobileCard.getUserName() + "☆五星级会员,恭喜您登陆成功!\n");
                    return true;
                } else if (number.trim().equals(numberKey.trim()) == true && passWord.trim().equals(mobileCard.getPassWord().trim()) == false) {
                    System.out.println("尊敬的☆" + mobileCard.getUserName() + "☆五星级会员,很遗憾您密码输入错误~");
                    return false;
                }
            }
            System.out.println("对不起,您还没有注册会员~");
            return false;
        } else {
            System.out.println("对不起,您还没有注册会员~");
            return false;
        }
    }


    /**
     * 手机号码验证是否已经注册
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
            System.out.println("对不起此号码还不是移动会员~");
            return false;
        } else {
            System.out.println("对不起此号码还不是移动会员~");
            return false;
        }
    }


    /**
     * 生成随机卡号
     */
    public static String createNumber() {
        Random random = new Random();
        boolean isExist = false;
        String number = "";
        int temp = 0;
        do {
            isExist = false;
            //生成的随机数是8位
            do {
                temp = random.nextInt(100000000);
            } while (temp < 10000000);
            //生成之前，前面加“139”
            number = "139" + temp;
            //和已经注册的用户的卡号对比，重复则无法注册
            if (cards != null) { //价格判断
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
     * 生成指定个数的卡号列表
     */
    public static String[] getNewNumbers(int count) {
        String[] strs = new String[count];
        for (int i = 0; i < count; i++) {
            strs[i] = createNumber();
        }
        return strs;
    }

    /**
     * 添加指定卡号的消费记录
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