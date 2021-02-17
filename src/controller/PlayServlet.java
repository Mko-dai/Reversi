package controller;

import java.io.IOException;
import java.util.ArrayList;

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

		/*セッション開始 */
		HttpSession session = request.getSession(true);

        /* 黒のマス目(記号)格納用変数 */
		String blackSquare[][];
		blackSquare = new String[8][8];

		/* 白のマス目(記号)格納用変数 */
		String whiteSquare[][];
		whiteSquare = new String[8][8];

		/* 無色のマス目(empty)格納用変数 */
		String[][] nullSquare;
		nullSquare = new String[8][8];

		/* 白と黒の行数(i)と列数(j)格納用変数 0から7が入る */
        ArrayList<int[]> blackSquareArray64_i = new ArrayList<int[]>();
        ArrayList<int[]> blackSquareArray64_j = new ArrayList<int[]>();
        ArrayList<int[]> whiteSquareArray64_i = new ArrayList<int[]>();
        ArrayList<int[]> whiteSquareArray64_j = new ArrayList<int[]>();

        /* マス目を左上から繰り返す */
		for (int i = 0; i<8; i++)
		{
			for (int j = 0; j<8; j++)
			{
				/* 黒を置くマス目の処理 */
			    if ((i == 3 && j == 3) || (i == 4 && j == 4))
			    {
                    /* 黒の記号を入れてjspへ飛ばす */
			    	blackSquare[i][j] = "●";

			    	/* 黒のマス目の周囲8マスの行数(i)と列数(j)を記録 */
			    	int[] blackSquareArry_i = new int[3];
					int[] blackSquareArry_j = new int[3];
			    	blackSquareArry_i[0] = i-1;
			    	blackSquareArry_i[1] = i;
			    	blackSquareArry_i[2] = i+1;
			    	blackSquareArry_j[0] = j-1;
			    	blackSquareArry_j[1] = j;
			    	blackSquareArry_j[2] = j+1;
			    	blackSquareArray64_i.add(blackSquareArry_i);
			    	blackSquareArray64_j.add(blackSquareArry_j);

			    }

			    /* 白を置くマス目の処理 */
			    else if ((i == 4 && j == 3) || (i == 3 && j == 4))
			    {
			    	/* 白の記号を入れてjspへ飛ばす */
			    	whiteSquare[i][j] = "○";

			    	/* 白のマス目の周囲8マスの行数(i)と列数(j)を記録 */
					int[] whiteSquareArry_i = new int[3];
					int[] whiteSquareArry_j = new int[3];
			    	whiteSquareArry_i[0] = i-1;
			    	whiteSquareArry_i[1] = i;
			    	whiteSquareArry_i[2] = i+1;
			    	whiteSquareArry_j[0] = j-1;
			    	whiteSquareArry_j[1] = j;
			    	whiteSquareArry_j[2] = j+1;
			    	whiteSquareArray64_i.add(whiteSquareArry_i);
			    	whiteSquareArray64_j.add(whiteSquareArry_j);

			    }

			    /* 無色のマス目の処理 */
			    else
			    {
			    	/* 無色のマス目に文字列emptyを格納 */
			    	nullSquare[i][j] = "empty";
			    }

			}
		}

        /* 白の周囲の無色マスの行数(k)と列数(l)を格納する変数 */
		ArrayList<int[]> emptyArroundWhiteList = new ArrayList<int[]>();

        /* 白の周囲のマスの行数配列(i)の要素をk、列数配列(j)の要素をlに代入して取り出す */
		for (int[] i:whiteSquareArray64_i)
		{
			for (int[] j:whiteSquareArray64_j)
			{
				for (int k:i)
				{
					for (int l:j)
					{
						if (k>= 0 && k<8 && l>= 0 && l<8)
						{
							/* 白の周囲の無色マスの行数(k)と列数(l)を格納 */
							if(nullSquare[k][l] == "empty")
							{
								int[] emptyNum = new int[2];
								emptyNum[0] = k;
								emptyNum[1] = l;
								emptyArroundWhiteList.add(emptyNum);
							}
						}
					}
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
