package org.top.orderpage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.orderpage.dao.OrderDAO;
import org.top.orderpage.entity.OrderTEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    @Override
    public void init() {
        orderDAO = new OrderDAO();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertOrder(request, response);
                    break;
                case "/delete":
                    deleteOrder(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateOrder(request, response);
                    break;
                default:
                    listOrders(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<OrderTEntity> listOrders = orderDAO.getAllOrders();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long idF = Long.parseLong(request.getParameter("idF"));
        OrderTEntity existingOrder = orderDAO.getOrderById(idF);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);

    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nameF = request.getParameter("nameF");
        String emailF = request.getParameter("emailF");
        String phoneF = request.getParameter("phoneF");
        String addressF = request.getParameter("addressF");


        OrderTEntity newOrder = new OrderTEntity();
        newOrder.setNameF(nameF);
        newOrder.setEmailF(emailF);
        newOrder.setPhoneF(phoneF);
        newOrder.setAddressF(addressF);
        orderDAO.insertOrder(newOrder);
        response.sendRedirect("list");
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long idF = Long.parseLong(request.getParameter("idF"));
        String nameF = request.getParameter("nameF");
        String emailF = request.getParameter("emailF");
        String phoneF = request.getParameter("phoneF");
        String addressF = request.getParameter("addressF");

        OrderTEntity newOrder = new OrderDAO().getOrderById(idF);
        newOrder.setNameF(nameF);
        newOrder.setEmailF(emailF);
        newOrder.setPhoneF(phoneF);
        newOrder.setAddressF(addressF);

        orderDAO.updateOrder(newOrder);
        response.sendRedirect("list");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long idF = Long.parseLong(request.getParameter("idF"));

        orderDAO.deleteOrderById(idF);
        response.sendRedirect("list");

    }
}