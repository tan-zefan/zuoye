package adminis;

import java.util.Scanner;

public class Operator extends User {
	
	public Operator(String name, String password, String role) {
		// TODO Auto-generated constructor stub
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****欢迎进入档案浏览员菜单****\n\t" +
							"1.上传文件\n\t" +
							"2.下载文件\n\t" +
							"3.文件列表\n\t" +
							"4.修改密码\n\t" +
							"5.退        出\n" +
							"***********************************");
	}

	@Override
	boolean select() {
		Scanner sc = new Scanner(System.in);
		int se = sc.nextInt();
		switch(se) {
		case 1:
			System.out.println(".......上传文件");
			return true;
		case 2:
			System.out.println("请输入文件名：");
			String fileName = sc.next();
			this.downloadFile(fileName);
			return true;
		case 3:
			this.showFileList();
			return true;
		case 4:
			System.out.println("请输入你的新密码：");
			this.setPassword(sc.next());
			return true;
		case 5:
			System.out.println("界面退出, 谢谢使用 ! ");
			return false;
		default:
			System.out.println("输入错误！");
			return true;
		}
	}

}
