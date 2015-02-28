package com.controladores.animales;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class especie
 */
@WebServlet("/especie")
public class especie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public especie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*BufferedWriter bw = new BufferedWriter(new FileWriter(new File("c:\\temp\\salida2.txt")));
		bw.write("vamos regular");
		bw.flush();
		bw.close();
		
		ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext( new String[] {"classpath:\\META-INF\\spring\\applicationContext.xml"});
		Especie e = new Especie();
		e.setNombre("aaa");
		e.persist();
		e = new Especie();
		e.setNombre("bbb");
		e.persist();
		e = new Especie();
		e.setNombre("ccc");
		e.persist();
		bw = new BufferedWriter(new FileWriter(new File("c:\\temp\\salida2.txt")));
		bw.newLine();
		bw.write("Numero entidades" + String.valueOf(Especie.countEspecies()));
		bw.close();*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
