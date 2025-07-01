package com.market.marketprojectone.persistence;

/**
 *
 * @author victus
 */
public class DAOFactory {
    private static ICategorieDAO categorieDAO = new CategorieDAO();
    private static IOrderItemsDAO orderItemsDAO = new OrderItemsDAO();
    private static IOrderDAO orderDAO = new OrderDAO();
    private static IProductDAO productDAO = new ProductDAO();
    private static ISupplierDAO supplierDAO = new SupplierDAO();

    public static ICategorieDAO getCategorieDAO() {
        return categorieDAO;
    }

    public static IOrderItemsDAO getOrderItemsDAO() {
        return orderItemsDAO;
    }

    public static IOrderDAO getOrderDAO() {
        return orderDAO;
    }

    public static IProductDAO getProductDAO() {
        return productDAO;
    }

    public static ISupplierDAO getSupplierDAO() {
        return supplierDAO;
    }
    
}
