package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PlayServlet
 */
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);

		String square[][];
		square = new String[8][8];

		String blackSquare[][];
		blackSquare = new String[8][8];

		String whiteSquare[][];
		whiteSquare = new String[8][8];

		String nullSquare[][];
		nullSquare = new String[8][8];




		for (int i = 0; i<8; i++)
		{
			for (int j = 0; j<8; j++)
			{
			    if ((i == 3 && j == 3) || (i == 4 && j == 4))
			    {

			    	blackSquare[i][j] = "●";

			    }
			    else if ((i == 4 && j == 3) || (i == 3 && j == 4))
			    {

			    	whiteSquare[i][j] = "○";
			    }
			    else
			    {
			    	nullSquare[i][j] = " ";
			    }


			}
		}

		String color = "black";
        session.setAttribute("color", color);
		session.setAttribute("blackSquare",blackSquare);
		session.setAttribute("whiteSquare",whiteSquare);
		session.setAttribute("nullSquare",nullSquare);

		RequestDispatcher rd = request.getRequestDispatcher("/view/Play.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		String color = (String) session.getAttribute("color");

		if (color == "black")
		{
			session.setAttribute("color", "white");
		}
		else if (color == "white")
		{
			session.setAttribute("color", "black");
		}




	}

}
