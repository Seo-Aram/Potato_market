package potato.controller.sign;

import potato.controller.IController;
import potato.process.command.AbsCommand;
import potato.process.command.UserCommand;
import potato.util.InputString;

public class UserMenuController implements IController {

	@Override
	public boolean process() {
		// TODO Auto-generated method stub
		AbsCommand command = new UserCommand();
		int inputMenu;

		while (true) {
			System.out.println();
			System.out.println("\tMy Page");
			System.out.println("======================");
			System.out.println("  1. 내 정보 보기");
			System.out.println("  2. 내 정보 수정하기");
			System.out.println("  3. 이전 화면으로 돌아가기");
			System.out.println("======================");
			System.out.println();
			System.out.print("원하시는 작업 번호를 입력해주세요 >> ");
			System.out.println();
			inputMenu = InputString.inputInt();

			if (inputMenu == 3) {

				return false;
			}

			command.command.get(inputMenu).process();
		}

	}
}