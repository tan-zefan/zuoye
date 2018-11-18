package adminis;

import java.util.Scanner;

public class Browser extends User {

	public Browser(String name, String password, String role) {
		// TODO Auto-generated constructor stub
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****��ӭ���뵵�����Ա�˵�****\n\t" + 
							"1.�����ļ�\n\t" +
							"2.�ļ��б�\n\t" +
							"3.�޸�����\n\t" +
							"4.��        ��\n" +
							"***********************************");
	}

	@Override
	boolean select() {
		Scanner sc = new Scanner(System.in);
		int se = sc.nextInt();
		switch(se) {
		case 1:
			System.out.println("�������ļ�����");
			String fileName = sc.next();
			this.downloadFile(fileName);
			return true;
		case 2:
			this.showFileList();
			return true;
		case 3:
			System.out.println("��������������룺");
			this.setPassword(sc.next());
			return true;
		case 4:
			System.out.println("�����˳�, ллʹ�� ! ");
			return false;
		default:
			System.out.println("�������");
			return true;
		}
	}

}
