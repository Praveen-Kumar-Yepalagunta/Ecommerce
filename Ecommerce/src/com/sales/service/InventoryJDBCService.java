package com.sales.service;

import java.sql.*;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.sales.domain.Product;
import com.sales.service.intf.InventoryServiceIntf;
import com.sales.service.intf.InventoryServiceJDBCIntf;

public class InventoryJDBCService implements InventoryServiceJDBCIntf{
	
	
	public Product addInventory(Connection con,Product prod)
	{
		try {
			PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?,?)");
			ps.setInt(1, prod.getId());
			ps.setString(2, prod.getProductName());
			ps.setString(3, prod.getMfName());
			ps.setDouble(4, prod.getPrice());
			ps.setInt(5, prod.getQty());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prod;
	}
	
	public void showAProduct(Product prod)
	{
		System.out.println("Product Id:"+prod.getId());
		System.out.println("Product Name:"+prod.getProductName());
		System.out.println("Manufacture's Name:"+prod.getMfName());
		System.out.println("Product Price :"+prod.getPrice());
		System.out.println("In Stock :"+prod.getQty());
		System.out.println("Stock value of the product:"+prod.getStockValue());
	}
	
	public void showAllProducts(Connection con)
	{
	  try {
		  Statement stmt= con.createStatement();
		  String s="SELECT * from products";
				  
		//PreparedStatement ps = con.prepareStatement("INSERT INTO Products values(6,'bag','strore ojbects',999,3)");
		  ResultSet rs=stmt.executeQuery(s);
		  
		  System.out.println("Product id\tProduct Name\tManufacturer Name\tPrice\tQuantity");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4)+","+rs.getInt(5));
		  }
		  rs.close();
		  stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public Product searchForProductId(Connection con,int prodId) {
		Product prod=null;
		
		/*if(list.size()>0)
		{
			Iterator<Product> iterator=list.iterator();
			while(iterator.hasNext())
			{
				prod=iterator.next();
				if(prod.getId()==prodId)
					return prod;
			}
		}*/
		return null;
	}
	
	public Product updateProductUsingId(Connection con,int prodId,int qty,double price)
	{
		/*Product findProd=searchForProductId(list, prodId);
		if(findProd!=null)
		{
			findProd.setPrice(price);
			findProd.setQty(qty);
			return findProd;
		}*/
		return null;
		
		
	}
	
	public boolean deleteProduct(Connection con,Product prod)
	{
		
		return false;
		
	}
	
}
