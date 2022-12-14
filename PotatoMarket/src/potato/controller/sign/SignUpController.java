package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.sign.UserIdCheckService;
import potato.service.sign.SignUpService;
import potato.util.EncryptString;
import potato.util.InputString;

public class SignUpController implements IController {

	private SignUpService service = new SignUpService();
	private UserIdCheckService service2 = new UserIdCheckService();

	@Override
	public boolean process() {
		while (true) {
			System.out.println();
			System.out.println("·.̩₊̣.̩✧*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩⋆·̩̩.̩̥·̩̩⋆*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩✧·.̩₊̣.̩‧ ");
			System.out.println("\t   감 자 마 켓");
			System.out.println("   감자마켓은 동네 직거래 마켓이에요.");
			System.out.println("      회원가입을 시작해보세요!");
			System.out.println("·.̩₊̣.̩✧*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩⋆·̩̩.̩̥·̩̩⋆*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩✧·.̩₊̣.̩‧ ");
			System.out.println();
			String userid = service2.checkId();
			String password = null;
			boolean run = true;

			while (run) {
				System.out.print("2-1. 비밀번호를 첫 설정해주세요 >>");
				password = InputString.inputDefaultString();
				System.out.print("2-2. 비밀번호를 한 번 더 입력하세요 >> ");
				run = PasswordCheckProcess.chkPassword(password);

				try {
					password = EncryptString.encryptAES256(password);
				} catch (Exception e) {
					System.out.println("프로그램 에러.");
					return false;
				}
			}

			System.out.print("3. 거주지역을 설정해주세요 >>");
			String loc = InputString.inputDefaultString();
			System.out.print("4. 닉네임을 설정해주세요 >> ");
			String nickname = InputString.inputDefaultString();

			int result = service.signUp(new UserData(userid, password, loc, nickname));

			if (result > 0) {
				System.out.println();
				System.out.println("축하합니다!");
				System.out.println("회원가입에 성공했습니다.");
				System.out.println();
				break;

			} else {
				System.out.println("회원가입에 실패했습니다.");
				System.out.println("다시 회원가입이 진행됩니다.");

			}

		}
		return true;
	}
	

}
