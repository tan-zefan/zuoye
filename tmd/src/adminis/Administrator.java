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
		System.out.println("****��ӭ���뵵������Ա�˵�****\n\t" +
							"1.�޸��û�\n\t" +
							"2.ɾ���û�\n\t" +
							"3.�����û�\n\t" +
							"4.�г��û�\n\t" +
							"5.�����ļ�\n\t" +
							"6.�ļ��б�\n\t" +
							"7.�޸�(����)�û���������\n\t" +
							"8.��        ��\n" +
							"***********************************");
	}

	void changeUserInfo() {
		System.out.println("��ѡ����Ҫ�޸ĵ����ݣ�\n\t" +
							"1.�û���\n\t" +
							"2.����");
		Scanner sc = new Scanner(System.in);
		int se = sc.nextInt();
		if(se == 1){
			System.out.println("������������û�����");
			this.setName(sc.next());
		}
		if(se == 2){
			System.out.println("��������������룺");
			this.setPassword(sc.next());
		}
		else
			System.out.println("���Ҳ磡");
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
			System.out.println("������Ҫɾ�����û�����");
			String strName = sc.next();
			DataProcessing.delete(strName);
			return true;
		case 3:
			System.out.println("������Ҫ�������û�����");
			String strName1 = sc.next();
			System.out.println("���������룺");
			String strPassword = sc.next();
			System.out.println("�������ɫ��");
			String strRole = sc.next();
			DataProcessing.update(strName1, strPassword, strRole);
			return true;
		case 4:
			System.out.print("�û���\t" + "����\t" + "��ɫ\n");
//			Enumeration<User> e = DataProcessing.getAllUser();
//			for (Enumeration<User> e = DataProcessing.getAllUser(); e.hasMoreElements();) {
//				System.out.print(e.nextElement().getName() + "\t\t"); //+ "\t" + e.nextElement().getPassword() + "\t" + e.nextElement().getRole());
//			}
//			System.out.print("\n����\t");
//			for (Enumeration<User> e = DataProcessing.getAllUser(); e.hasMoreElements();) {
//				System.out.print(e.nextElement().getPassword() + "\t\t"); //+ "\t" + e.nextElement().getPassword() + "\t" + e.nextElement().getRole());
//			}
//			System.out.print("\n��ɫ\t");
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
			System.out.println("�������ļ�����");
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
			System.out.println("�����˳�, ллʹ�� ! ");
			return false;
		default:
			System.out.println("�������");
			return true;
		}
	}
	
}
