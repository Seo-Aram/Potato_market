package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.EditMemService;
import potato.util.EncryptString;
import potato.util.InputString;

public class EditMemController implements IController {

	private EditMemService service = new EditMemService();

	public boolean process() {

		boolean result = false;

		while (true) {
			System.out.println();
			System.out.println("회원 정보를 수정합니다.");
			System.out.println();
			System.out.print("비밀번호를 수정해주세요 >> ");
			String password = InputString.inputDefaultString();

			try {
				password = EncryptString.encryptAES256(password);
			} catch (Exception e) {
				System.out.println("프로그램 에러.");
				return false;
			}

			System.out.print("거주지역을 수정해주세요 >> ");
			String loc = InputString.inputDefaultString();
			System.out.print("닉네임을 수정해주세요 >> ");
			String nickname = InputString.inputDefaultString();

			UserData userdata = new UserData(password, loc, nickname);
			if (service.editMem(userdata)) {
				System.out.println("수정이 완료되었습니다!");
				System.out.println();
				result = true;
				break;

			} else {
				System.out.println("오류가 발생하여 수정이 실패하였습니다.");
				System.out.println("다시 수정을 진행합니다.");
				result = false;

			}
		}
		return result;
	}
}