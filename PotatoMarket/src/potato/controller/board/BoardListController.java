package potato.controller.board;

import java.util.List;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.process.command.AbsCommand;
import potato.process.command.BoardCommand;
import potato.service.board.BoardListService;
import potato.util.InputString;

// 게시물 리스트 출력을 서비스에 요청하는 서비스 클래스
// List<Board> 출력
public class BoardListController implements IController {

	BoardListService service = new BoardListService(new BoardDao());

	@Override
	public boolean process() {

		List<Board> list = service.allBoardPrint();

		if (list != null && !list.isEmpty()) {
			for (Board b : list) {
				System.out.println(b);
			}
		} else {
			System.out.println("현재 등록된 게시물이 없습니다.");
		}
	
		// 세부 선택지(커맨드) 추가
		AbsCommand command = new BoardCommand();
		int inputmenu;
		while (true) {

			System.out.println("======================");
			System.out.println("1. 판매 게시글 작성하기");
			System.out.println("2. 상품 검색하기");
			System.out.println("3. 상품 구매하기");
			System.out.println("4. 판매 게시글 수정");
			System.out.println("5. 판매 게시글 삭제");
			System.out.println("6. 이전 화면으로 돌아가기");
			System.out.println("======================");
			System.out.println();

			inputmenu = InputString.inputInt();
			if(inputmenu==6) {
				return false;
			}
			command.command.get(inputmenu).process();
		}
	}

}
