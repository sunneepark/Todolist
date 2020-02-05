package kr.or.connect.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.dao.TodoDao;
import kr.or.connect.dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //TodoDao 이용해서 전체 리스트 뿌려주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<TodoDto> list = new ArrayList<TodoDto>();
		list = new TodoDao().getTodos(); 
		
		
		System.out.println(list.get(1));
		
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        request.setAttribute("todolist", list);
        requestDispatcher.forward(request, response);
	}

	
}
