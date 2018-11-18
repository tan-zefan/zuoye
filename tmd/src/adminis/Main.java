package adminis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tip_system = "档案系统";
		String tip_menu = "请选择菜单：";
		String tip_exit = "系统退出，欢迎使用！";
		String infos = "****欢迎进入" + tip_system + "****\n\t       " + 
						"1.登录\n  \t         2.退出\n" +
						"********************************************************";
		String name, password;
		boolean flag = true;
//		System.out.print("请选择菜单:");
		while(true) {
			Scanner sc = new Scanner(System.in);
	//		int se = sc.nextInt();
			System.out.println("(输入exit退出程序)请输入用户名：");
			
			name = sc.next();
			if(name.equals("exit")) {
				System.out.println("系统退出, 谢谢使用 !");
				break;
			}
			System.out.println("请输入密码：");
			password = sc.next();
			
			User user = DataProcessing.search(name, password);
			if(user == null){
				System.out.println("用户名密码错误！");
				return;
			}
			while(flag) {
				user.showMenu();
				flag = user.select();
			}
		}
	}
}
