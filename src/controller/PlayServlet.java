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
        ArrayList<int[]> blackAroundSquareArray_i_j = new ArrayList<int[]>();
        ArrayList<int[]> whiteAroundSquareArray_i_j = new ArrayList<int[]>();


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

			    	int up_i     = i-1;
			    	int center_i = i;
			    	int down_i   = i+1;
			    	int left_j   = j-1;
			    	int center_j = j;
			    	int right_j  = j+1;

			    	int up_i_left_j[] = {up_i, left_j};
			    	int up_i_center_j[] = {up_i, center_j};
			    	int up_i_right_j[] = {up_i, right_j};

			    	int center_i_left_j[] = {center_i, left_j};
			    	int center_i_right_j[] = {center_i, right_j};

			    	int down_i_left_j[] = {down_i, left_j};
			    	int down_i_center_j[] = {down_i, center_j};
			    	int down_i_right_j[] = {down_i, right_j};

			    	blackAroundSquareArray_i_j.add(up_i_left_j);
			    	blackAroundSquareArray_i_j.add(up_i_center_j);
			    	blackAroundSquareArray_i_j.add(up_i_right_j);
			    	blackAroundSquareArray_i_j.add(center_i_left_j);
			    	blackAroundSquareArray_i_j.add(center_i_right_j);
			    	blackAroundSquareArray_i_j.add(down_i_left_j);
			    	blackAroundSquareArray_i_j.add(down_i_center_j);
			    	blackAroundSquareArray_i_j.add(down_i_right_j);

			    }

			    /* 白を置くマス目の処理 */
			    else if ((i == 4 && j == 3) || (i == 3 && j == 4))
			    {
			    	/* 白の記号を入れてjspへ飛ばす */
			    	whiteSquare[i][j] = "○";

			    	/* 白のマス目の周囲8マスの行数(i)と列数(j)を記録 */
			    	int up_i     = i-1;
			    	int center_i = i;
			    	int down_i   = i+1;
			    	int left_j   = j-1;
			    	int center_j = j;
			    	int right_j  = j+1;

			    	int up_i_left_j[] = {up_i, left_j};
			    	int up_i_center_j[] = {up_i, center_j};
			    	int up_i_right_j[] = {up_i, right_j};

			    	int center_i_left_j[] = {center_i, left_j};
			    	int center_i_right_j[] = {center_i, right_j};

			    	int down_i_left_j[] = {down_i, left_j};
			    	int down_i_center_j[] = {down_i, center_j};
			    	int down_i_right_j[] = {down_i, right_j};

			    	whiteAroundSquareArray_i_j.add(up_i_left_j);
			    	whiteAroundSquareArray_i_j.add(up_i_center_j);
			    	whiteAroundSquareArray_i_j.add(up_i_right_j);
			    	whiteAroundSquareArray_i_j.add(center_i_left_j);
			    	whiteAroundSquareArray_i_j.add(center_i_right_j);
			    	whiteAroundSquareArray_i_j.add(down_i_left_j);
			    	whiteAroundSquareArray_i_j.add(down_i_center_j);
			    	whiteAroundSquareArray_i_j.add(down_i_right_j);

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

		for (int[] i:whiteAroundSquareArray_i_j)
		{
			if (i[0]>= 0 && i[0]<8 && i[1]>= 0 && i[1]<8)
			{
				/* 白の周囲の無色マスの行数(k)と列数(l)を格納 */
				if(nullSquare[i[0]][i[1]] == "empty")
				{
					emptyArroundWhiteList.add(i);
				}
			}

		}

		ArrayList<ArrayList<ArrayList<int[]>>> xyzAroundWhiteList = new ArrayList<ArrayList<ArrayList<int[]>>>(); /* 列数 */

		for (int[] i:emptyArroundWhiteList)
		{
			ArrayList<int[]> xArroundWhiteList = new ArrayList<int[]>(); /* 列数 */
			ArrayList<int[]> yArroundWhiteList = new ArrayList<int[]>(); /* 行数 */
			ArrayList<int[]> zDownArroundWhiteList = new ArrayList<int[]>(); /* 斜め\ */
			ArrayList<int[]> zUpArroundWhiteList = new ArrayList<int[]>(); /* 斜め/ */

			int y = i[0];
			int x = i[1];

			for (int j=1; j<8; j++)
			{
			    if (x+j < 8)
			    {
				    int yAround[] = {y,x+j};
			        yArroundWhiteList.add(yAround);
			    }

			    if (x-j >= 0)
			    {
				    int yAround[] = {y,x-j};
			        yArroundWhiteList.add(yAround);
			    }


			    if (y+j < 8)
			    {
			        int xAround[] = {y+j, x};
			        xArroundWhiteList.add(xAround);
			    }

			    if (y-j >= 0)
			    {
			        int xAround[] = {y-j, x};
			        xArroundWhiteList.add(xAround);
			    }


			    if (y+j < 8 && x+j < 8 )
			    {
		     	    int zDownAroundRight[] = {y+j, x+j};
			       	zDownArroundWhiteList.add(zDownAroundRight);
			    }

			    if (y-j >= 0 && x-j >= 0)
			    {
			       	int zDownAroundLeft[] = {y-j, x-j};
		        	zDownArroundWhiteList.add(zDownAroundLeft);
		        }

		    	if (y-j >= 0 && x+j < 8)
		    	{
		    		int zUpAroundRight[] = {y-j, x+j};
		    		zUpArroundWhiteList.add(zUpAroundRight);
		    	}

		    	if (y+j < 8 && x-j >= 0)
		    	{
		    		int zUpAroundLeft[] = {y+j, x-j};
		    		zUpArroundWhiteList.add(zUpAroundLeft);
		    	}

			    ArrayList<ArrayList<int[]>> xyzArround = new ArrayList<ArrayList<int[]>>();
			    xyzArround.add(xArroundWhiteList);
			    xyzArround.add(yArroundWhiteList);
			    xyzArround.add(zDownArroundWhiteList);
			    xyzArround.add(zUpArroundWhiteList);

			    xyzAroundWhiteList.add(xyzArround);
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
