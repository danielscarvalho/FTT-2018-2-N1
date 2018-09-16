<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.edu.cefsa.ftt.ec.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products List</title>

</head>
<body>
<h1>Products List</h1>
<a href="product.html">New Product</a>

<%
  ArrayList<ProductBean> prodDados= (ArrayList<ProductBean>)request.getAttribute("produtosDados");

  int size = prodDados.size();	  
  
  if(!prodDados.isEmpty())	  {
%>
    <table>
      <tr>
           <th>ID</th>
           <th>Description</th>
           <th>Value</th>
      </tr>
<%	  
      for(int contador=0; contador<size; contador++) {	
%> 	  
      <tr>	
            <%-- <td><%= prodDados.get(contador) %></td>    --%>
            <td><%= prodDados.get(contador).getpId() %></td> 
            <td><%= prodDados.get(contador).getpDescription() %></td> 
            <td><%= prodDados.get(contador).getpValue() %></td>    
            <td>
                <!-- JSPs permite apenas GET, POST or HEAD - Testar DELETE com Postman  -->
	            <form method="delete" action="/FTT_2018_2_N1/product">
	               <input type="hidden" name="pid" value="<%= prodDados.get(contador).getpId() %>"></input>
	               <button type="submit">Del</button>
	            </form>
            </td>
           	
      </tr>        
<%	    
       } //for
%>
       </table>
<% 
  
  } else {
%>
  	  <h2>Não há produtos na lista...</h2> 	  
<% 
  } //if	
%>
</body>
</html>