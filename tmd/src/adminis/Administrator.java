package adminis;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Administrator extends User {

	public Administrator(String name, String password, String role) {
		// TODO Auto-generated constructor stub
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****欢迎进入档案管理员菜单****\n\t" +
							"1.修改用户\n\t" +
							"2.删除用户\n\t" +
							"3.新增用户\n\t" +
							"4.列出用户\n\t" +
							"5.下载文件\n\t" +
							"6.文件列表\n\t" +
							"7.修改(本人)用户名或密码\n\t" +
							"8.退        出\n" +
							"***********************************");
	}

	void changeUserInfo() {
		System.out.println("请选择你要修改的内容：\n\t" +
							"1.用户名\n\t" +
							"2.密码");
		Scanner sc = new Scanner(System.in);
		int se = sc.nextInt();
		if(se == 1){
			System.out.println("请输入你的新用户名：");
			this.setName(sc.next());
		}
		if(se == 2){
			System.out.println("请输入你的新密码：");
			this.setPassword(sc.next());
		}
		else
			System.out.println("你找茬！");
		sc.close();
	}
	
	boolean select(){
		Scanner sc = new Scanner(System.in);
		int se = sc.nextInt();
		switch(se){
		case 1:
			this.changeUserInfo();
			return true;
		case 2:
			System.out.println("请输入要删除的用户名：");
			String strName = sc.next();
			DataProcessing.delete(strName);
			return true;
		case 3:
			System.out.println("请输入要新增的用户名：");
			String strName1 = sc.next();
			System.out.println("请输入密码：");
			String strPassword = sc.next();
			System.out.println("请输入角色：");
			String strRole = sc.next();
			DataProcessing.update(strName1, strPassword, strRole);
			return true;
		case 4:
			System.out.print("用户名\t" + "密码\t" + "角色\n");
//			Enumeration<User> e = DataProcessing.getAllUser();
//			for (Enumeration<User> e = DataProcessing.getAllUser(); e.hasMoreElements();) {
//				System.out.print(e.nextElement().getName() + "\t\t"); //+ "\t" + e.nextElement().getPassword() + "\t" + e.nextElement().getRole());
//			}
//			System.out.print("\n密码\t");
//			for (Enumeration<User> e = DataProcessing.getAllUser(); e.hasMoreElements();) {
//				System.out.print(e.nextElement().getPassword() + "\t\t"); //+ "\t" + e.nextElement().getPassword() + "\t" + e.nextElement().getRole());
//			}
//			System.out.print("\n角色\t");
//			for (Enumeration<User> e = DataProcessing.getAllUser(); e.hasMoreElements();) {
//				System.out.print(e.nextElement().getRole() + "\t"); //+ "\t" + e.nextElement().getPassword() + "\t" + e.nextElement().getRole());
//			}
//			System.out.println();
			for(Iterator it = DataProcessing.users.entrySet().iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				System.out.println(DataProcessing.users.get(entry.getKey()).getName() + "\t" + DataProcessing.users.get(entry.getKey()).getPassword() + "\t" + DataProcessing.users.get(entry.getKey()).getRole());
			}
				
			return true;
		case 5:
			System.out.println("请输入文件名：");
			String fileName = sc.next();
			this.downloadFile(fileName);
			return true;
		case 6:
			this.showFileList();
			return true;
		case 7:
			this.changeUserInfo();
			return true;
		case 8:
			System.out.println("界面退出, 谢谢使用 ! ");
			return false;
		default:
			System.out.println("输入错误！");
			return true;
		}
	}
	
}
