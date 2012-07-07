<%@ page language="java" pageEncoding="UTF-8"%>
<%
    out.print("{ \"elements\": [ { \"type\": \"pie\", \"start-angle\": 35, \"animate\": [ { \"type\": \"fade\" } ], \"tip\": \"#val# of #total# #percent# of 100%\", \"values\": [ 2, 3, 6, 3, 5, 3 ] } ], \"title\": { \"text\": \"Cows go mooo\" }, \"x_axis\": null }");
%>