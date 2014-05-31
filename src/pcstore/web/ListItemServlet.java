package pcstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcstore.ejb.ItemManage;
import pcstore.ejb.Item;
import defaultnamespace.*;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * Servlet implementation class ListItemServlet
 */
@WebServlet("/ListItem")
public class ListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ItemManage im;
	MemCachedClient client;
	SockIOPool pool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getClient();
		String rtn_json = (String) client.get("items_rtn_json");
		if (null == rtn_json){
			System.out.println("Load from DB");
			List<Item> items = im.getAllItems();
			
			rtn_json = "";
			rtn_json += "{\"Item\":[";

			for (int i = 0; i < items.size(); i++) {
				if (i != 0) {
					rtn_json += ",";

				}
				rtn_json = rtn_json + "{\"Name\":\"" + items.get(i).getName()
						+ "\",\"Price\":\"" + items.get(i).getPrice()
						+ "\",\"Stock\":\"" + items.get(i).getStock() + "\"}";
			}
			rtn_json += "]}";
			client.add("items_rtn_json", rtn_json);
		}
		else{
			System.out.println("Load from Memory");
		}
		
		response.setContentType("application/x-json");
		PrintWriter out = response.getWriter();
		out.println(rtn_json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OrderProcessService op = new OrderProcessService();
		OrderProcess port = op.getPort(OrderProcess.class);
		PrintWriter out = response.getWriter();
		String order = request.getParameter("order");
		String rtn = port.orderProcess(order);
		out.println(rtn);
	}

	private void getClient() {
		client = new MemCachedClient();
		String[] addr = { "127.0.0.1:22222" };
		Integer[] weights = { 3 };
		pool = SockIOPool.getInstance();
		pool.setServers(addr);
		pool.setWeights(weights);
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(200);
		pool.setMaxIdle(1000 * 30 * 30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.setSocketConnectTO(0);
		pool.initialize();
	}

}
