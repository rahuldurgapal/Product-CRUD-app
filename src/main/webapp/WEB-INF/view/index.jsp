<%-- 
    Document   : index
    Created on : 29-Apr-2024, 11:07:24 AM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="base.jsp" %>
    </head>
    <body>
        <div calss="container mt-3">
            <div class="row">
                <div class="col-md-12">

                    <h1 class="text-center mb-3">Welcome To Product App</h1>
                  
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">S.No.</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Product Description</th>
                                <th scope="col">Product Price</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${product}" var="p">
                            <tr>
                                <th scope="row">TECHONLY${p.id}</th>
                                <td>${p.name}</td>
                                <td>${p.description}</td>
                                <td class="font-weight-bold">&#x20B9;${p.price}</td>
                                <td>
                                    <a href="delete-product/${p.id}"><i class="fa-sharp fa-solid fa-trash text-danger" style="font-size: 20px;"></i></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                 
                    
                    <div class="container text-center">
                        <a href="add-product" class="btn btn-outline-success" >Add Product</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
