package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PutAndChangeServlet
 */
public class PutAndChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutAndChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String color = (String) session.getAttribute("color");
		ArrayList<int[]> changeSquareList2 = (ArrayList<int[]>) session.getAttribute("changeSquareList2");  /* 黒に変えられる白のマス */
		ArrayList<int[]> canPutSquareList= (ArrayList<int[]>) session.getAttribute("canPutSquareList");          /* 黒をおける無色のマス */
		String SquareColor[][];
		SquareColor = (String[][]) session.getAttribute("SquareColor");             /* マスの色 */
		int PutY = Integer.parseInt(request.getParameter("y"));
		int PutX = Integer.parseInt(request.getParameter("x"));

		if (color== "black")
		{
			SquareColor[PutY][PutX] = "●";
		}
		else if (color== "white")
		{
			SquareColor[PutY][PutX] = "○";
		}















		if (color == "black")
		{
			session.setAttribute("color", "white");
		}
		else if (color == "white")
		{
			session.setAttribute("color", "black");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
