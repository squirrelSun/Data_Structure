package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//简单计算器（后缀表达式）

public class calculator_polian {

	public static void main(String[] args) {

		String expression = "1+((2+3)*4)-5";
		System.out.println("1+((2+3)*4)-5" + "=" + (1+((2+3)*4)-5));
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
		List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
		System.out.println("后缀表达式对应的List" + suffixExpreesionList); // ArrayList [1,2,3,+,4,*,+,5,–]

		System.out.printf("expression=%d", calculate(suffixExpreesionList)); 
	}

	// 将得到的中缀表达式对应的List => 后缀表达式对应的List
	public static List<String> parseSuffixExpreesionList(List<String> ls) {
		// 定义两个栈
		Stack<String> s1 = new Stack<String>(); // 符号栈
		List<String> s2 = new ArrayList<String>(); // 储存中间结果的Lists2

		// 遍历ls
		for (String item : ls) {
			// 如果是一个数，加入s2
			if (item.matches("\\d+")) {
				s2.add(item);
			} else if (item.equals("(")) {
				s1.push(item);
			} else if (item.equals(")")) {
				// 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//将 ( 弹出 s1栈， 消除小括号
			} else {
				// 当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				// 还需要将item压入栈
				s1.push(item);
			}
		}

		// 将s1中剩余的运算符依次弹出并加入s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}

		return s2; // 按顺序输出就是对应的后缀表达式对应的List

	}

	// 方法：将 中缀表达式转成对应的List
	public static List<String> toInfixExpressionList(String s) {
		// 定义一个List,存放中缀表达式 对应的内容
		List<String> ls = new ArrayList<String>();
		int i = 0; // 这时是一个指针，用于遍历 中缀表达式字符串
		String str; // 对多位数的拼接
		char c; // 每遍历到一个字符，就放入到c
		do {
			// 如果c是一个非数字，我需要加入到ls
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++; // i需要后移
			} else { // 如果是一个数，需要考虑多位数
				str = ""; // 先将str 置成"" '0'[48]->'9'[57]
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;// 拼接
					i++;
				}
				ls.add(str);
			}
		} while (i < s.length());
		return ls;
	}

	// 将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
	public static List<String> getListString(String suffixExpression) {
		// 将 suffixExpression 分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;

	}

	// 完成对逆波兰表达式的运算
	public static int calculate(List<String> ls) {
		Stack<String> stack = new Stack<String>();
		// 遍历 ls
		for (String item : ls) {
			// 这里使用正则表达式来取出数
			if (item.matches("\\d+")) { // 匹配的是多位数
				// 入栈
				stack.push(item);
			} else {
				// pop出两个数，并运算， 再入栈
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("运算符有误");
				}
				// 把res 入栈
				stack.push("" + res);
			}
		}
		// 最后留在stack中的数据是运算结果
		return Integer.parseInt(stack.pop());
	}

}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	// 返回对应的优先级数字
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		}
		return result;
	}

}
