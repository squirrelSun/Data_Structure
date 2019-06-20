
public class Common {
	//实例化话唠套餐
    //括号参数分别对应(价格，通话时间，短信数量)
    static TalkPackage talkPackage = new TalkPackage(58, 500, 30);
    //实例化网虫套餐
    //括号参数分别对应(价格，上网流量)
    static NetPackage netPackage = new NetPackage(68, 3 * 1024);
    //实例化超人套餐
    //括号参数分别对应(价格，通话时间，短信数量,上网流量)
    static SuperPackage superPackage = new SuperPackage(78, 200, 50, 1 * 1024);
}
