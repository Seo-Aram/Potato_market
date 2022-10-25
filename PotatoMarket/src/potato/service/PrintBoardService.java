package potato.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

public class PrintBoardService {

	// 컨트롤러에서 요청을 받아와 게시물 리스트 출력 처리하는 클래스
	BoardDao dao;

	public PrintBoardService(BoardDao dao) {
		this.dao = dao;
	}

	// 리스트 출력
	public List<Board> allBoardPrint() {

		List<Board> list = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection(); // 커넥션으로 DB 연결
			list = dao.selectBoard(conn); // 저장된 게시물 dao에서 불러오는 메소드 사용

		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
	
	

}