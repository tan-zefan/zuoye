package adminis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tip_system = "����ϵͳ";
		String tip_menu = "��ѡ��˵���";
		String tip_exit = "ϵͳ�˳�����ӭʹ�ã�";
		String infos = "****��ӭ����" + tip_system + "****\n\t       " + 
						"1.��¼\n  \t         2.�˳�\n" +
						"********************************************************";
		String name, password;
		boolean flag = true;
//		System.out.print("��ѡ��˵�:");
		while(true) {
			Scanner sc = new Scanner(System.in);
	//		int se = sc.nextInt();
			System.out.println("(����exit�˳�����)�������û�����");
			
			name = sc.next();
			if(name.equals("exit")) {
				System.out.println("ϵͳ�˳�, ллʹ�� !");
				break;
			}
			System.out.println("���������룺");
			password = sc.next();
			
			User user = DataProcessing.search(name, password);
			if(user == null){
				System.out.println("�û����������");
				return;
			}
			while(flag) {
				user.showMenu();
				flag = user.select();
			}
		}
	}
}
